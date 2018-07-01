package skd.app.androidfeatures.jsonReader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import skd.app.androidfeatures.R;

public class JsonReader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_reader);

        TextView textView = (TextView)findViewById(R.id.textView3);

        try {
            textView.setText(loadJSONFromAsset("a.txt"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public String loadJSONFromAsset(String filename) throws Exception {
        String json = null;
        try {
            InputStream is = this.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
