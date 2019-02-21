package skd.app.androidfeatures.serviceDemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.serviceDemo.services.Service1;
import skd.app.androidfeatures.serviceDemo.services.Service2;

public class ServiceDemoActivity extends AppCompatActivity {

    Button ser1_start,ser1_stop,forSer1_start,forSer1_stop;
    Context mContext;

    Service2 mBoundService;
    boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        mContext=this;


        //Find view
        ser1_start = (Button)findViewById(R.id.ser1_start);
        ser1_stop = (Button)findViewById(R.id.ser1_stop);
        forSer1_start = (Button)findViewById(R.id.forser1);
        forSer1_stop = (Button)findViewById(R.id.forser1_stop);


        //services
        final Intent service1 = new Intent(mContext, Service1.class);
        final Intent service2 = new Intent(mContext, Service2.class);


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

        forSer1_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startService(service2);
                bindService(new Intent(mContext, Service2.class),mServiceConnection,BIND_AUTO_CREATE);

            }
        });





    }
    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.wtf("SKDINFO", "ServiceDemoActivity onServiceConnected ");

           // Service2.MyBinder myBinder = (Service2.MyBinder) service;

            mBoundService = ((Service2.MyBinder)service).getService();
            mServiceBound = true;
        }
    };

}
