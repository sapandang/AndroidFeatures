package skd.app.androidfeatures.rhinojsTest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import skd.app.androidfeatures.R;

import static skd.app.androidfeatures.utils.FilesUtil.ReadFileToString;

public class RhinojsTest extends AppCompatActivity {

    android.content.Context mContext;
    RhinojsTest mRhinojsTest;

   public EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhinojs_test);
        mContext=this;
        mRhinojsTest=this;

        //Find View
        editText = (EditText)findViewById(R.id.editText4);


        /**
         *This is the basic code which embeeds rhino
         * init Rhino
         * COMMENTED  -> To test rhino js
         */
        /*
        Context mozillaJsContext = Context.enter();
        mozillaJsContext.setOptimizationLevel(-1);

        Scriptable scope = mozillaJsContext.initStandardObjects();

        // Pass the Stock Java object to the JavaScript context
        Object wrappedStock = Context.javaToJS(mContext, scope);
        Object wrappedcur = Context.javaToJS(mRhinojsTest, scope);
        ScriptableObject.putProperty(scope, "ctx", wrappedStock);
        ScriptableObject.putProperty(scope, "cur", wrappedcur);

        String source = ""+ReadFileToString(this,"rhinojs.js");
        //Script scriptjs = mozillaJsContext.compileString(source, "sandeepDemoScript", 1, null);
        //Object jsObjectResult = scriptjs.exec(mozillaJsContext, scope);

        Object jsObjectResult = mozillaJsContext.evaluateString(scope, source, "EvaluationScript", 1, null);
        String result = Context.toString(jsObjectResult);
        editText.setText(result);
        */

        JsRunner mJsRunner = new JsRunner(mContext);
        mJsRunner.addVariable("cur",mRhinojsTest);
        mJsRunner.addVariable("ctx",mContext);
        mJsRunner.build();

        Object jsObjectResult = mJsRunner.evaluateString(ReadFileToString(this,"rhinojs.js"));
        editText.setText(mJsRunner.objectToString(jsObjectResult));



    }

    public void showToast(String text)
    {
        Toast.makeText(mContext,""+text,Toast.LENGTH_SHORT).show();
    }
}
