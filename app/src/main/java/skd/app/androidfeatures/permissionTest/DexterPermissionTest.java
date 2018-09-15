package skd.app.androidfeatures.permissionTest;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.tankery.permission.PermissionRequestActivity;
import skd.app.androidfeatures.R;

public class DexterPermissionTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dexter_permission_test);
        PermissionRequestActivity.start(this,11,new String[]{ Manifest.permission.CAMERA}, "help", "appexit");

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            if (resultCode == RESULT_OK) {
            Toast.makeText(this,"you Pass ",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,"you Failed ",Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }
    }
}
