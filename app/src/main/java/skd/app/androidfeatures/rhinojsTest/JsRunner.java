package skd.app.androidfeatures.rhinojsTest;

import android.support.annotation.NonNull;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * class providing the features to embeed and rhino in android
 */
public class JsRunner {

    Context jsContext; //main RhinoJs Context
    ScriptableObject scope; //RhinoJs scope

    private static final String SOURCE_NAME = "jsrunner";

    /**
     * Android application context.
     */
    android.content.Context mContext;

    /**
     * Java classes to import into the javascript environment.
     */
    private final Set<Class<?>> mClasses = new HashSet<>();

    /**
     * Java packages to import into the javascript environment.
     * All classes inside the package will be imported.
     */
    private final Set<String> mPackages = new HashSet<>();

    /**
     * Variables to bind to the javascript environment.
     */
    private final Map<String, Object> mVariables = new HashMap<>();

    /**
     * Global mFunctions to add to the javascript environment.
     */
    private final Map<String, Function> mFunctions = new HashMap<>();



    public JsRunner(@NonNull android.content.Context context)
    {
        // We import the app's package name by default
        mPackages.add(context.getPackageName());
    }

    /**
     * Setups a proper javascript context so that it can run javascript code properly under android.
     * For android we need to disable bytecode generation since the android vms don't understand JVM bytecode.
     * @return a proper javascript context
     */
    static @NonNull Context enterJsContext() {
        final Context jsContext = Context.enter();

        // If we cause the context to throw a runtime exception from this point
        // we need to make sure that exit the context.
        try {
            jsContext.setLanguageVersion(Context.VERSION_1_8);

            // We can't let Rhino to optimize the JS and to use a JIT because it would generate JVM bytecode
            // and android runs on DEX bytecode. Instead we need to go in interpreted mode.
            jsContext.setOptimizationLevel(-1);
        } catch (RuntimeException e) {
            // Something bad happened to the javascript context but it might still be usable.
            // The first thing to do is to exit the context and then propagate the error.
            Context.exit();
            throw e;
        }

        return jsContext;
    }

    /**
     * This method initalise the RhinoEngine for running
     * @return JsRunner
     */
    public JsRunner build()
    {
        jsContext = JsRunner.enterJsContext();
        ImporterTopLevel importerTopLevel = new ImporterTopLevel(jsContext);
        scope = jsContext.initStandardObjects(importerTopLevel, false);
        ScriptableObject.putProperty(scope, "context", Context.javaToJS(mContext, scope));
        try {
            importClasses(jsContext, scope);
            importPackages(jsContext, scope);
            importVariables(scope);
            importFunctions(scope);
        } catch (JsRunnerException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }


        return this;
    }

    /**
     * this method evaluates the expressions
     * @param expression
     * @return
     */
    public Object evaluateString(String expression)
    {
        Object result;
        result = jsContext.evaluateString(scope, expression, "chrome", 1, null);

        // Google chrome automatically saves the last expression to `$_`, we do the same
        Object jsValue = Context.javaToJS(result, scope);
        return jsValue;
    }

    /**
     * this method return jsObject as String
     */
    public String objectToString(Object tObject)
    {
       return Context.toString(tObject);
    }

    /**
     * Request that the given java class be imported in the javascript runtime.
     * @param aClass the java class to import
     * @return the builder
     */
    public @NonNull
    JsRunner importClass(@NonNull Class<?> aClass) {
        mClasses.add(aClass);
        return this;
    }

    /**
     * Request that the given package name will be imported in the javascript runtime.
     * This means that all classes (enums and interfaces) will be imported.
     * @param packageName the java package name to import
     * @return the builder
     */
    public @NonNull
    JsRunner importPackage(@NonNull String packageName) {
        mPackages.add(packageName);
        return this;
    }

    /**
     * Add a variable (binding) to the javascript environment.
     * @param name the javascript variable name
     * @param value the value to add
     * @return the builder
     */
    public JsRunner addVariable(@NonNull String name, Object value) {
        mVariables.put(name, value);
        return this;
    }

    /**
     * Adds a function to the javascript environment.
     * @param name the javascript function name
     * @param function the function
     * @return the builder
     */
    public @NonNull
    JsRunner addFunction(@NonNull String name, @NonNull Function function) {
        mFunctions.put(name, function);
        return this;
    }

    private void importClasses(@NonNull Context jsContext, @NonNull ScriptableObject scope) throws JsRunnerException{
        // Import the classes that the caller requested
        for (Class<?> aClass : mClasses) {
            String className = aClass.getName();
            try {
                // import from default classes
                String expression = String.format("importClass(%s)", className);
                jsContext.evaluateString(scope, expression, SOURCE_NAME, 1, null);
            } catch (Exception e) {
                try {
                    // import from application classes
                    String expression = String.format("importClass(Packages.%s)", className);
                    jsContext.evaluateString(scope, expression, SOURCE_NAME, 1, null);
                } catch (Exception e1) {
                    throw new JsRunnerException(e1, "Failed to import class: %s", className);
                }
            }
        }
    }

    private void importPackages(@NonNull Context jsContext, @NonNull ScriptableObject scope) throws JsRunnerException {
        // Import the packages that the caller requested
        for (String packageName : mPackages) {
            try {
                // import from default packages
                String expression = String.format("importPackage(%s)", packageName);
                jsContext.evaluateString(scope, expression, SOURCE_NAME, 1, null);
            } catch (Exception e) {
                try {
                    // import from application packages
                    String expression = String.format("importPackage(Packages.%s)", packageName);
                    jsContext.evaluateString(scope, expression, SOURCE_NAME, 1, null);
                } catch (Exception e1) {
                    throw new JsRunnerException(e, "Failed to import package: %s", packageName);
                }
            }
        }
    }



    private void importVariables(@NonNull ScriptableObject scope) throws JsRunnerException {
        // Define the variables
        for (Map.Entry<String, Object> entrySet : mVariables.entrySet()) {
            String varName = entrySet.getKey();
            Object varValue = entrySet.getValue();
            try {
                Object jsValue;
                if (varValue instanceof Scriptable || varValue instanceof Undefined) {
                    jsValue = varValue;
                } else {
                    jsValue = Context.javaToJS(varValue, scope);
                }
                ScriptableObject.putProperty(scope, varName, jsValue);
            } catch (Exception e) {
                throw new JsRunnerException(e, "Failed to setup variable: %s", varName);
            }
        }
    }

    private void importFunctions(@NonNull ScriptableObject scope) throws JsRunnerException {
        // Define the functions
        for (Map.Entry<String, Function> entrySet : mFunctions.entrySet()) {
            String functionName = entrySet.getKey();
            Function function = entrySet.getValue();
            try {
                ScriptableObject.putProperty(scope, functionName, function);
            } catch (Exception e) {
                throw new JsRunnerException(e, "Failed to setup function: %s", functionName);
            }
        }
    }

    private static class JsRunnerException extends Exception {
        JsRunnerException(Throwable rootCause, String format, Object...args) {
            super(args.length == 0 ? format : String.format(format, args), rootCause);
        }
    }



}
