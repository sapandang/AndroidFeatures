package skd.app.androidfeatures.downloadDemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.utils.DownloadUtils;

public class DownladActivity extends AppCompatActivity {


    Button downloadbtn;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downlad);
        mContext = this;

        downloadbtn = (Button) findViewById(R.id.button6);

        Log.wtf("SKDINFO", "download activity");


        downloadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Start",Toast.LENGTH_SHORT).show();

                /*AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setView(R.layout.dialog_progress);
                AlertDialog dialog = builder.create();
                dialog.setCancelable(false);
                dialog.show();
*/
           // progress.show();

              // t.start();
                        DownloadUtils down = new DownloadUtils(mContext,"http://mirrors.jenkins.io/war-stable/latest/jenkins.war","package.zip");
                       // DownloadUtils down = new DownloadUtils(mContext,"http://192.168.0.106/test/package.zip","package.zip");
                        down.startDownload();


            }
        });


    }
}
