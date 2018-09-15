package skd.app.androidfeatures.webviewTest;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.forms.MainForm;

public class WebAppInterface {
    Context mContext;
    String mValueFile=null;
    // Instantiate the interface and set the context
    public WebAppInterface(Context c ) {
        mContext = c;
    }

    public WebAppInterface(Context c ,String valueFile) {
        mContext = c;
        mValueFile = valueFile;
    }

    // Show a toast from the web page
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public int getAndroidVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    @JavascriptInterface
    public void showAndroidVersion(String versionName) {
        Toast.makeText(mContext, versionName, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public String getData() {
        if(mValueFile!=null)
        {
            try {
                Log.wtf("SKDINFO","passing editble value to the file");
                return FileUtils.readFileToString(new File(mValueFile)).toString();
            }catch (Exception e)
            {
                throw new RuntimeException("value file not found");
            }
        }
      return "{\"radio\":\"my-radio4\",\"checkbox\":[\"4\"]}";
    }

    @JavascriptInterface
    public void saveData(String data) {
        SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
        String filename = s.format(new Date());

        File dataFile = new File(MainForm.filledFormsDir.getAbsolutePath()+"/"+filename+".json");
        try {
            FileUtils.writeStringToFile(dataFile,data);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error Creating file");
        }

    }

}