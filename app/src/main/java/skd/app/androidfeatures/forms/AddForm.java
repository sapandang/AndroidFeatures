package skd.app.androidfeatures.forms;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.webviewTest.WebAppInterface;

import static skd.app.androidfeatures.forms.MainForm.downloadFormsDir;

public class AddForm extends AppCompatActivity {

    WebView webView;
    Context mContext;
    //Parameter Data
    String valueFileName =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        mContext=this;
        //get the bundle
        Bundle b = getIntent().getExtras();
        if(b!=null)
        {
            valueFileName = b.getString("VALUE_FILE_NAME");
        }


        webView = (WebView)findViewById(R.id.wb);
        if(valueFileName!=null) {
            setUpWebView(downloadFormsDir.getAbsolutePath() + "/" + "test3.html",valueFileName);

        }else
        {
            setUpWebView(downloadFormsDir.getAbsolutePath() + "/" + "test3.html");

        }
    }



    public void setUpWebView(String fileName)
    {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/test3.html");
        //webView.loadUrl("file:///"+fileName);

        webView.addJavascriptInterface(new WebAppInterface(this,webView), "AndroidInterface"); // To call methods in Android from using js in the html, AndroidInterface.showToast, AndroidInterface.getAndroidVersion etc

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            private ProgressDialog mProgress;

            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (mProgress == null) {
                    mProgress = new ProgressDialog(mContext);
                    mProgress.show();
                }
                mProgress.setMessage("Loading " + String.valueOf(progress) + "%");
                if (progress == 100) {
                    mProgress.dismiss();
                    mProgress = null;
                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public void setUpWebView(String fileName,String valueFile)
    {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/test3.html");
        //webView.loadUrl("file:///"+fileName);

        webView.addJavascriptInterface(new WebAppInterface(this,valueFile), "AndroidInterface"); // To call methods in Android from using js in the html, AndroidInterface.showToast, AndroidInterface.getAndroidVersion etc

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

}
