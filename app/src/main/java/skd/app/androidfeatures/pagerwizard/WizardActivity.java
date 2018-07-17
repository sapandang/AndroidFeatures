package skd.app.androidfeatures.pagerwizard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.utils.FilesUtil;
import skd.app.androidfeatures.viewPagerDemo.PagerItem;
import skd.app.androidfeatures.viewPagerDemo.ZoomOutPageTransformer;

public class WizardActivity extends AppCompatActivity {


    ViewPager mViewPager;
    AppCompatActivity appCompatActivity;

    JSONObject mJsonData;       //stores the FORM main JSON after parsing

    Button mNextButton; //next button
    Button mPrevButton; //prevButton
    ArrayList<Fragment> fragmentsHolder;    //Fragments Holders

    JSONObject dataSet = new JSONObject();
    JSONObject wizardJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_wizard);
        appCompatActivity = this;
        fragmentsHolder = new ArrayList<>();


        //setup the JSON
        mJsonData = new JSONObject();
        try {
            //Parse the JSON
            Log.wtf("INFO", "parsing the json component tree");
            wizardJson = new JSONObject(FilesUtil.ReadFileToString(this, "a.txt"));
            JSONArray componentsArray = wizardJson.getJSONArray("components");
            Log.wtf("INFO", "componet Tree length " + componentsArray.length());
            //currenty each componets corresponds to panel
            for (int i = 0; i < componentsArray.length(); i++) {

                //check if the components is of panel type then create the FORM fragment
                JSONObject tJsonObject = componentsArray.getJSONObject(i);
                if (tJsonObject.get("type").toString().toLowerCase().equals("panel")) {
                    Log.wtf("INFO", "Created Fragment " + i);
                    FormFragment tFormFragment = new FormFragment();
                    tFormFragment.setComponentArrary(componentsArray);
                    fragmentsHolder.add(tFormFragment);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.wtf("ERROR", "Error while putting json data PageWizard ");
        }

        //find the views
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mNextButton = (Button) findViewById(R.id.next_btn);
        mPrevButton = (Button) findViewById(R.id.prv_btn);


        //setup the pager
        FragmentsViewer fragmentsViewer = new FragmentsViewer(getSupportFragmentManager());
        mViewPager.setAdapter(fragmentsViewer);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setOffscreenPageLimit(100);

        //setup button listner
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);

            }
        });


    }


    /**
     * Fragments Adapter
     * This class directly refer to fragmentsHolder object
     * fragmentsHolder holder holds the list of Fragments
     */
    class FragmentsViewer extends FragmentStatePagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();


        public FragmentsViewer(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentsHolder.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "" + position;
        }

        @Override
        public int getCount() {
            return fragmentsHolder.size();
        }
    }

}
