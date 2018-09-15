package skd.app.androidfeatures.forms;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.sRecylerView.SingleDataSelAdapter;

public class EditForm extends AppCompatActivity {

    public static Context context;

    //Below are the componets which are required by the Recycler view
    RecyclerView recyclerView; //this will hold the recycler view from the layout
    RecyclerView.Adapter   mAdapter; //this will hold the adapter for the recycler view
    RecyclerView.LayoutManager mLayoutmanager; //holds the layout manager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_form);
        context = this;

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
        mAdapter = new EditFormAdapter(loadAllFilledFormFromDisk(),context);
        recyclerView.setAdapter(mAdapter);
    }


    public ArrayList<FormsModel> loadAllFilledFormFromDisk()
    {
        ArrayList<FormsModel> tFormsModels = new ArrayList<>();
        File filledDir =MainForm.filledFormsDir;

        File[] formFileArrary =  filledDir.listFiles();
        Log.wtf("SKDINFO","Found filled forms  "+formFileArrary.length);

        for (int i=0;i<formFileArrary.length;i++)
        {
            Log.wtf("SKDINFO",""+formFileArrary[i].getName());
            FormsModel fm = new FormsModel();
            fm.setFile(formFileArrary[i]);
            tFormsModels.add(fm);
        }

        return tFormsModels;
    }


}
