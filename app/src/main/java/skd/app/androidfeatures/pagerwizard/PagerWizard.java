package skd.app.androidfeatures.pagerwizard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.utils.FilesUtil;
import skd.app.androidfeatures.viewPagerDemo.PagerActivity;
import skd.app.androidfeatures.viewPagerDemo.PagerItem;
import skd.app.androidfeatures.viewPagerDemo.ZoomOutPageTransformer;

public class PagerWizard extends AppCompatActivity {


    ViewPager mViewPager;
    AppCompatActivity appCompatActivity;

     JSONObject mJsonData;

     Button mNextButton;
     Button mPrevButton;
     ArrayList<Fragment> fragmentsHolder;

     JSONObject dataSet =  new JSONObject();
    JSONObject wizardJson;
    public ArrayList<String> dummySpinerAdapter = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_wizard);
        appCompatActivity =this;
        fragmentsHolder =  new ArrayList<>();


        //generate adapeter dummy data
        for(int i=0;i<10;i++)
        {
            dummySpinerAdapter.add("item "+i);
        }

        //setup the JSON
        mJsonData = new JSONObject();
        try {
            mJsonData.put("text1", "");
            mJsonData.put("text2", "");
            mJsonData.put("text3", "");

            //Parse the JSON
            wizardJson =  new JSONObject(FilesUtil.ReadFileToString(this,"a.txt"));
            JSONArray componentsArray = wizardJson.getJSONArray("components");
            for(int i=0;i<10;i++)
            {
                FormFragment tFormFragment = new FormFragment();
                tFormFragment.setComponentArrary(componentsArray);
                fragmentsHolder.add(tFormFragment);
            }



        }catch (Exception e)
        {
            e.printStackTrace();
            Log.wtf("ERROR","Error while putting json data PageWizard ");
        }

        //find the views
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mNextButton = (Button) findViewById(R.id.next_btn);
        mPrevButton = (Button) findViewById(R.id.prv_btn);

        //set up pager
        FragmentsViewer fragmentsViewer = new FragmentsViewer(getSupportFragmentManager());
        fragmentsViewer.addFragment(new PagerItem(),"Colors");
        fragmentsViewer.addFragment(new PagerItem(),"Properties");
        fragmentsViewer.addFragment(new PagerItem(),"Settings");
        fragmentsViewer.addFragment(new PagerItem(),"34");



        for(int i= 0;i<0;i++)
        {
            PagerItem pi = new PagerItem();
            pi.setTitle("tile "+i);
            fragmentsHolder.add(pi);
        }



        //setup the pager
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mViewPager.setAdapter(fragmentsViewer);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setOffscreenPageLimit(100);

        //setup button listner
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PagerItem pi = (PagerItem)fragmentsHolder.get(mViewPager.getCurrentItem());
                if(pi.canMove()) {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                }

            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);

            }
        });



    }

    class FragmentsViewer extends FragmentStatePagerAdapter
    {
        int CurrentPosition=0;
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public FragmentsViewer(FragmentManager fm)
        {
            super(fm);
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position)
        {
            return  fragmentsHolder.get(position);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return ""+position;
        }
        @Override
        public int getCount()
        {
            return fragmentsHolder.size();
        }
    }

}
