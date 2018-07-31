package skd.app.androidfeatures.pagerwizard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import skd.app.androidfeatures.R;
import skd.app.androidfeatures.viewPagerDemo.ZoomOutPageTransformer;

public class SimpleWizard extends AppCompatActivity {

    AppCompatActivity appCompatActivity;
    ViewPager mViewPager;
    ArrayList<Fragment> fragmentsHolder;
    Button mNextButton;
    Button mPrevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_wizard);
        appCompatActivity = this;
        fragmentsHolder = new ArrayList<>();

        //find the views
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mNextButton = (Button) findViewById(R.id.next_btn);
        mPrevButton = (Button) findViewById(R.id.prv_btn);

        //data init
        fragmentsHolder.add(new SimpleFragment1());

        //handllers


        //setup the pager
        SimpleWizard.FragmentsViewer fragmentsViewer = new SimpleWizard.FragmentsViewer(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mViewPager.setAdapter(fragmentsViewer);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setOffscreenPageLimit(100);

    }




    class FragmentsViewer extends FragmentStatePagerAdapter
    {


        public FragmentsViewer(FragmentManager fm)
        {
            super(fm);
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
