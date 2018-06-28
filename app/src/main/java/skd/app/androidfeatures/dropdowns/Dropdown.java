package skd.app.androidfeatures.dropdowns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import skd.app.androidfeatures.R;

public class Dropdown extends AppCompatActivity {


    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown);

        //sppinnder data create arrary list
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("yoo");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");
        arrayList.add("bye bye");



        spinner = findViewById(R.id.spinner);
        //create array adapter and provide arrary list to it
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);





    }
}
