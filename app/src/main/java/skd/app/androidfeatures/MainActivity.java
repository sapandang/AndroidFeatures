package skd.app.androidfeatures;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import skd.app.androidfeatures.compoundview.CompoundViewActivity;
import skd.app.androidfeatures.fingerPrintDemo.FingerActivity;
import skd.app.androidfeatures.inflatorDemo.InflatorActivity;
import skd.app.androidfeatures.menu.MenuAdapter;
import skd.app.androidfeatures.menu.MenuModel;
import skd.app.androidfeatures.sRecylerView.RecylerActivity;
import skd.app.androidfeatures.serviceDemo.DemoService;
import skd.app.androidfeatures.viewPagerDemo.PagerActivity;

public class MainActivity extends AppCompatActivity {

    public static MainActivity mainActivity;

    RecyclerView recyclerView; //this will hold the recycler view from the layout
    RecyclerView.Adapter   mAdapter; //this will hold the adapter for the recycler view
    RecyclerView.LayoutManager mLayoutmanager; //holds the layout manager



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        mainActivity = this;

        recyclerView = (RecyclerView) findViewById(R.id.menu_recycler_view);
        mLayoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutmanager);

        //adapter
        ArrayList<MenuModel> menuList = new ArrayList<>();
        menuList.add(new MenuModel("Recycler Activity",RecylerActivity.class));
        menuList.add(new MenuModel("Finger Print Authentication",FingerActivity.class));
        menuList.add(new MenuModel("View Pager demo",PagerActivity.class));
        menuList.add(new MenuModel("Inflator Demo",InflatorActivity.class));
        menuList.add(new MenuModel("Custom Widget Demo",CompoundViewActivity.class));

        mAdapter = new MenuAdapter(menuList);

        recyclerView.setAdapter(mAdapter);

    }
}
