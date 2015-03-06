package exe.boris.targetmaker.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import exe.boris.targetmaker.R;
import roboguice.fragment.provided.RoboFragment;

/**
 * Created by boris on 3/5/15.
 */
public class Audio extends roboguice.fragment.RoboFragment {

    public Audio() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.audio_fragment, container, false);
        return v;
    }
}