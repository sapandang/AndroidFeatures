package skd.app.androidfeatures.forms;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.util.List;

import me.tankery.permission.PermissionRequestActivity;
import skd.app.androidfeatures.R;
import skd.app.androidfeatures.utils.FilesUtil;
import skd.app.androidfeatures.webviewTest.WebAppInterface;
import timber.log.Timber;

public class MainForm extends AppCompatActivity {

    Button addBtn,viewBtn;
    public static File baseDir,downloadFormsDir,filledFormsDir,appdir;
    public static String baseDirPath,downloadFormsDirpath,filledFormsDirPath,appdirPath;
    String appDirName="tre";
    String downloadFormsDirName="downloadForm";
    String filledFormsDirName="filledForms";

    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);
        mContext=this;
        baseDir = Environment.getExternalStorageDirectory();

        PermissionRequestActivity.start(this,11,new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE}, "need to read external"
                , "read external form setting");
        PermissionRequestActivity.start(this,11,new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE}, "need to write external"
                , "write external form setting");


        addBtn = (Button)findViewById(R.id.add_btn);
        viewBtn = (Button)findViewById(R.id.view_btn);

        //Log
        Log.wtf("SKDINFO",""+ Environment.getExternalStorageDirectory());
        setupDirs();
       // someDirs();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext,AddForm.class);
                startActivity(i);
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext,EditForm.class);
                startActivity(i);
            }
        });



    }

    public void setupDirs()
    {
        try {
            Log.wtf("SKDINFO","appdir "+baseDir.getAbsolutePath()+"/"+appDirName);
            Log.wtf("SKDINFO","downloadDir "+baseDir.getAbsolutePath()+"/"+appDirName+"/"+downloadFormsDirName);
            Log.wtf("SKDINFO","filledformDir  "+baseDir.getAbsolutePath()+"/"+appDirName+"/"+filledFormsDirName);
/*

            FileUtils.forceMkdir(new File(baseDir.getAbsolutePath()+"/"+appDirName));
            FileUtils.forceMkdir(new File(baseDir.getAbsolutePath()+"/"+appDirName+"/"+downloadFormsDirName));
            FileUtils.forceMkdir(new File(baseDir.getAbsolutePath()+"/"+appDirName+"/"+filledFormsDirName));
*/

            appdir = new File(baseDir.getAbsolutePath(),appDirName);
            appdir.mkdirs();
            appdirPath= appdir.getAbsolutePath();

            filledFormsDir = new File(baseDir.getAbsolutePath()+"/"+appDirName+"/"+filledFormsDirName);
            downloadFormsDir = new File(baseDir.getAbsolutePath()+"/"+appDirName+"/"+downloadFormsDirName);
            filledFormsDir.mkdirs();
            downloadFormsDir.mkdirs();

            filledFormsDirPath = filledFormsDir.getAbsolutePath();
            downloadFormsDirpath = downloadFormsDir.getAbsolutePath();

        }catch (Exception e)
        {
            Log.wtf("SKDINFO","Exception  MainForm setupDirs ");
            throw new RuntimeException("MainForm setupDirs"+e);
        }
    }

    public void printAllDirs()
    {
        //print all the files
        try {
            File dir = Environment.getExternalStorageDirectory();
            Log.wtf("SKDINFO","Getting all files in " + dir.getCanonicalPath() + " including those in subdirectories");
            List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
            for (File file : files) {
                Log.wtf("SKDINFO","file: " + file.getCanonicalPath());
            }
        }catch (Exception e)
        {
            throw new RuntimeException("MainFORM error");
        }
    }

    public static void someDirs()
    {

         String ODK_ROOT = Environment.getExternalStorageDirectory()
                + File.separator + "matrix";
         File ft = new File(ODK_ROOT);
        if(!ft.mkdirs())
        {
            throw new RuntimeException("unable to create dirs");
        }


    }


}
