package skd.app.androidfeatures;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import skd.app.androidfeatures.serviceDemo.services.Service2;

public class BlankActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent service2 = new Intent(this, Service2.class);
        startService(service2);
        final Intent tr = new Intent(this, MainActivity.class);
        startActivity(tr);
        finish();


    }
}
