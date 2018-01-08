package skd.app.androidfeatures.viewPagerDemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import skd.app.androidfeatures.R;

public class PagerActivity extends AppCompatActivity {

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        mViewPager = (ViewPager)findViewById(R.id.viewpager);


        FragmentsViewer fragmentsViewer = new FragmentsViewer(getSupportFragmentManager());
        fragmentsViewer.addFragment(new PagerItem(),"Colors");
        fragmentsViewer.addFragment(new PagerItem(),"Properties");
        fragmentsViewer.addFragment(new PagerItem(),"Settings");
        fragmentsViewer.addFragment(new PagerItem(),"34");

        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mViewPager.setAdapter(fragmentsViewer);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());

    }


    class FragmentsViewer extends FragmentStatePagerAdapter
    {
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
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}
