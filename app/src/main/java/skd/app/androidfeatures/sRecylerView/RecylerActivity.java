package skd.app.androidfeatures.sRecylerView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import skd.app.androidfeatures.R;

public class RecylerActivity extends AppCompatActivity {

        public static Context context;
    //Below are the componets which are required by the Recycler view
    RecyclerView recyclerView; //this will hold the recycler view from the layout
    RecyclerView.Adapter   mAdapter; //this will hold the adapter for the recycler view
    RecyclerView.LayoutManager mLayoutmanager; //holds the layout manager

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_recyler); //layout which contain the recycler view

        //Find the Recycler view
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view); //got the recycler view from the layout

        //set the layout manager for the recycler view
        //standard layout managers( LinearLayoutManager or GridLayoutManager) can be used, or implement your own.
        //Layout Manager tells how the item are shown in your Recycler View
        mLayoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutmanager);

        //set the data adapter
        //Adapter contain the Data Which need to be shown in the view
        // mAdapter = new RvDataAdpt();
        mAdapter = new RvDataAdpt2(DummyModel.getDummyModel(100));
        recyclerView.setAdapter(mAdapter);
    }
}
