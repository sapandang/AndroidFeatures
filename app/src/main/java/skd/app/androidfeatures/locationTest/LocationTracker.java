package skd.app.androidfeatures.locationTest;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hypertrack.core_android_sdk.HyperTrackCore;

import me.tankery.permission.PermissionRequestActivity;
import skd.app.androidfeatures.R;

public class LocationTracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_tracker);
        PermissionRequestActivity.start(this,11,new String[]{ Manifest.permission.ACCESS_FINE_LOCATION}, "help", "appexit");
        HyperTrackCore.initialize(this, "pk_ee9515301c6bf88d16a8919c83111f5d5d6f1889");

    }
}
