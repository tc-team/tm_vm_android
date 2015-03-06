package exe.boris.targetmaker.view;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.MapFragment;

import exe.boris.targetmaker.R;

/**
 * Created by boris on 23.02.15.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;
    Context context;

    public MyPagerAdapter(android.support.v4.app.FragmentManager fm, Context c) {
        super(fm);
        context = c;
        tabs = c.getResources().getStringArray(R.array.tabs);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Map();
                break;
            case 1:
                fragment = new Audio();
                break;
        }
        return fragment;
    }
}