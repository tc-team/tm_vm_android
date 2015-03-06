package exe.boris.targetmaker.view;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import exe.boris.targetmaker.R;
import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActionBarActivity {

    @InjectView(R.id.viewpager) ViewPager pager;
    @InjectView(R.id.sliding_tabs) SlidingTabLayout slidingTabLayout;
    @InjectView(R.id.my_toolbar) Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolBar);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),getApplicationContext()));        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.primary));
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.text_secondary));
        slidingTabLayout.setViewPager(pager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!NetworkInformation.checkInternetConnection(getApplicationContext())) {
            Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_LONG).show();
        }
    }
}
