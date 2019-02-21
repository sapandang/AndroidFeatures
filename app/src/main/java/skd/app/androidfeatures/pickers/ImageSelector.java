package skd.app.androidfeatures.pickers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.fxn.pix.Pix;

import java.io.File;
import java.util.ArrayList;

import skd.app.androidfeatures.R;

public class ImageSelector extends AppCompatActivity {


    Button btn;
    ImageView imageView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        setContentView(R.layout.activity_image_selector);


        btn = (Button)findViewById(R.id.button7);
        imageView = (ImageView)findViewById(R.id.imageView2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pix.start(ImageSelector.this,                    //Activity or Fragment Instance
                        34,                //Request code for activity results
                        5);    //Number of images to restict selection count


            }
        });


    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 34) {
            ArrayList<String> returnValue = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            Toast.makeText(ImageSelector.this,""+returnValue.toString(),Toast.LENGTH_SHORT).show();
            File imageFile = new  File(returnValue.get(0));
            imageView.setImageBitmap(BitmapFactory.decodeFile(imageFile.getAbsolutePath()));


        }
    }
}
