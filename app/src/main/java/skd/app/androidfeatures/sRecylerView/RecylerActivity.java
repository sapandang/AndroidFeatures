package skd.app.androidfeatures.sRecylerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import skd.app.androidfeatures.R;

public class RecylerActivity extends AppCompatActivity {


    //Recycler View Vars
    RecyclerView recyclerView; //this will hold the recycler view from the layout
    RecyclerView.Adapter   mAdapter; //this will hold the adapter for the recycler view
    RecyclerView.LayoutManager mLayoutmanager; //holds the layout manager

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler);

        //Find the Recycler view
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view); //got the recycler view from the layout

        //set the layout manager for the recycler view
        mLayoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutmanager);

        //set the data adapter
        mAdapter = new RvDataAdpt();
        recyclerView.setAdapter(mAdapter);
    }
}
