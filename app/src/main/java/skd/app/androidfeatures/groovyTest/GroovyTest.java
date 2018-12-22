package skd.app.androidfeatures.groovyTest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
/*
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.codehaus.groovy.tools.shell.Shell;
import org.codehaus.groovy.tools.shell.commands.ImportCompleter;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;*/
import skd.app.androidfeatures.R;

import static skd.app.androidfeatures.utils.FilesUtil.ReadFileToString;

public class GroovyTest extends AppCompatActivity {

    //groovy
   // GroovyShell groovyShell;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groovy_test);
        context = this;
        Toast.makeText(this,"started..",Toast.LENGTH_SHORT).show();

        //initShell();
      //  groovyShell.evaluate(ReadFileToString(this,"groovytest.groovy"));
    }

    //setUpGroovy
 /*   public void initShell()
    {
        CompilerConfiguration compilerConfiguration = new CompilerConfiguration();

        ImportCustomizer importCustomizer = new ImportCustomizer();
        importCustomizer.addImports("android.widget.Toast");

        Binding binding= new Binding();
        binding.setProperty("context",this);
        groovyShell= new GroovyShell(Thread.currentThread().getContextClassLoader(),binding,compilerConfiguration);

    }*/

    public void showToast()
    {
        Toast.makeText(this,"Called from groovy ..",Toast.LENGTH_SHORT).show();

    }



}
