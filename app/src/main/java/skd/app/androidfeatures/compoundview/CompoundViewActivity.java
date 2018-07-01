package skd.app.androidfeatures.compoundview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

import skd.app.androidfeatures.R;

public class CompoundViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_view);

        //sppinnder data create arrary list
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i=0;i<100;i++)
        {
            arrayList.add("item"+i);
        }


        //Child DropDown data
        HashMap<String,ArrayList<String>> childDropDownData = new HashMap<>();

        for(int i=0;i<arrayList.size();i++)
        {
            ArrayList<String> tArrayList1 =  new ArrayList<>();
            for(int j=0;j<10;j++)
            {
                tArrayList1.add(arrayList.get(i)+" ==> sub item 1");
            }
            childDropDownData.put(arrayList.get(i),tArrayList1);
        }

        HashMap<String,ArrayList<String>> childDropDownData2 = new HashMap<>();
        for(int i=0;i<arrayList.size();i++)
        {
            ArrayList<String> tArrayList1 =  new ArrayList<>();
            for(int j=0;j<10;j++)
            {
                tArrayList1.add(arrayList.get(i)+" ==> sub item 2");
            }
            childDropDownData2.put(arrayList.get(i)+" ==> sub item 1",tArrayList1);
        }


        final ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("i am list 2");
        arrayList2.add("i am list 2");
        arrayList2.add("i am list 2");
        arrayList2.add("i am list 2");
        arrayList2.add("i am list 2");arrayList2.add("i am list 2");
        arrayList2.add("i am list 2");
        arrayList2.add("i am list 2");
        arrayList2.add("i am list 2");



        final DropDown dropDown = (DropDown)findViewById(R.id.cw1);
        final DropDown childDropDown = (DropDown)findViewById(R.id.cw2);
        final DropDown childDropDown2 = (DropDown)findViewById(R.id.cw3);

        Button button = (Button) findViewById(R.id.button5);


        dropDown.setDropDownData(arrayList);
        childDropDown.setMasterData(childDropDownData);
        dropDown.setChildDropDown(childDropDown);

        childDropDown2.setMasterData(childDropDownData2);
        childDropDown.setChildDropDown(childDropDown2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropDown.setDropDownData(arrayList2);
            }
        });

    }
}
