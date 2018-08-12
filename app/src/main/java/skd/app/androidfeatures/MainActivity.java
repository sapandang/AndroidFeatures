package skd.app.androidfeatures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import skd.app.androidfeatures.compoundview.CompoundViewActivity;
import skd.app.androidfeatures.dropdowns.DropdownS;
import skd.app.androidfeatures.fingerPrintDemo.FingerActivity;
import skd.app.androidfeatures.inflatorDemo.InflatorActivity;
import skd.app.androidfeatures.jsonReader.JsonReader;
import skd.app.androidfeatures.maps.LocationPickerTest;
import skd.app.androidfeatures.maps.MapsActivityTest;
import skd.app.androidfeatures.menu.MenuAdapter;
import skd.app.androidfeatures.menu.MenuModel;
import skd.app.androidfeatures.pagerwizard.PagerWizard;
import skd.app.androidfeatures.pagerwizard.SimpleWizard;
import skd.app.androidfeatures.pagerwizard.WizardActivity;
import skd.app.androidfeatures.sRecylerView.MultiSelectionRecycler;
import skd.app.androidfeatures.sRecylerView.RecylerActivity;
import skd.app.androidfeatures.sRecylerView.SimpleRecycler;
import skd.app.androidfeatures.sRecylerView.SingleSelectRecycler;
import skd.app.androidfeatures.sokcetdemo.SocketTest;
import skd.app.androidfeatures.toolbarTest.ToolbarTest;
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
        menuList.add(new MenuModel("क्या हाल है",CompoundViewActivity.class));
        menuList.add(new MenuModel("PagerWizard",PagerWizard.class));
        menuList.add(new MenuModel("DropDown", DropdownS.class));
        menuList.add(new MenuModel("JSON Reader", JsonReader.class));
        menuList.add(new MenuModel("Wizard Fragment", WizardActivity.class));
        menuList.add(new MenuModel("Socket Test", SocketTest.class));
        menuList.add(new MenuModel("Simple Wizard", SimpleWizard.class));
        menuList.add(new MenuModel("Multi Selection Recycler", MultiSelectionRecycler.class));
        menuList.add(new MenuModel("Single Select Recycler", SingleSelectRecycler.class));
        menuList.add(new MenuModel("Simple Recycler view", SimpleRecycler.class));
        menuList.add(new MenuModel("Location Picker", LocationPickerTest.class));
        menuList.add(new MenuModel("Map Test ", MapsActivityTest.class));
        menuList.add(new MenuModel("Toolbar Test ", ToolbarTest.class));




        mAdapter = new MenuAdapter(menuList);

        recyclerView.setAdapter(mAdapter);

    }
}
