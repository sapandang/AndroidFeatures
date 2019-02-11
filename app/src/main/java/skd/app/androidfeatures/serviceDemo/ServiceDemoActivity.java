package skd.app.androidfeatures.serviceDemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.serviceDemo.services.Service1;

public class ServiceDemoActivity extends AppCompatActivity {

    Button ser1_start,ser1_stop;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        mContext=this;


        //Find view
        ser1_start = (Button)findViewById(R.id.ser1_start);
        ser1_stop = (Button)findViewById(R.id.ser1_stop);

        //services
        final Intent service1 = new Intent(mContext, Service1.class);


        //handlers
        ser1_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(service1);
            }
        });
        ser1_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(service1);
            }
        });




    }
}
