package exe.boris.targetmaker.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import exe.boris.targetmaker.R;

/**
 * Created by boris on 23.02.15.
 */
public class MyPagerAdapter extends PagerAdapter {

    String[] tabs;
    Context context;

    public MyPagerAdapter(Context c) {
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
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view = null;
        switch (position) {
            case 0:
                view = inflater.inflate(R.layout.audio_fragment, container, false);
                container.addView(view);
            case 1:
                view = inflater.inflate(R.layout.map_fragment, container, false);
                container.addView(view);
        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }
}
