package skd.app.androidfeatures.dialogsDemo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.ConditionVariable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import skd.app.androidfeatures.R;

public class DialogActivity extends AppCompatActivity {

    Context mContext;
    Button alertDialogBtn,customDialogbtn1,dialogbtn2;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mContext =this;

        //find the view
        alertDialogBtn= (Button)findViewById(R.id.alertdialogbtn);
        customDialogbtn1= (Button)findViewById(R.id.dialog1);
        dialogbtn2= (Button)findViewById(R.id.dialog2);


        //handlers
        alertDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("alert !!");
                builder.setTitle("title");
                Dialog dialog = builder.create();
                dialog.show();
            }
        });

        customDialogbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setView(R.layout.dialog_progress);
                AlertDialog dialog = builder.create();
                //dialog.setCancelable(false);
                dialog.show();
            }
        });

        dialogbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setView(R.layout.downloader_layout);
                AlertDialog dialog = builder.create();
                //dialog.setCancelable(false);
                dialog.show();
                progressBar= (ProgressBar) dialog.findViewById(R.id.determinateBar);
                //progressBar.setIndeterminate(true);

                for(int i=0;i<100;i++)
                {

                    progressBar.incrementProgressBy(i);

                }
                progressBar.setSecondaryProgress(10);
            }
        });


    }
}
