package skd.app.androidfeatures.overlaydemo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.serviceDemo.DemoService;

/**
 * Created by sapan on 9/24/2017.
 */

public class OverlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overlay);

       // startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION));



        Intent intent = new Intent(this,DemoService.class);
        startService(intent);

    }
}
