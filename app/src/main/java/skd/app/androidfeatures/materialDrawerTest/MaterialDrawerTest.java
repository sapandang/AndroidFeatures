package skd.app.androidfeatures.materialDrawerTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mikepenz.materialdrawer.DrawerBuilder;

import skd.app.androidfeatures.R;

public class MaterialDrawerTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_drawer_test);
        new DrawerBuilder()
                .withDisplayBelowStatusBar(false)
                .withTranslucentStatusBar(false)
                .withActivity(this)
                .build();

    }
}
