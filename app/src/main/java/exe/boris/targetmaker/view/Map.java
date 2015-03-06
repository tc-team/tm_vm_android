package exe.boris.targetmaker.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import exe.boris.targetmaker.R;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

/**
 * Created by boris on 3/5/15.
 */
public class Map extends RoboFragment {

    @InjectView(R.id.map) MapFragment mapFragment;
    GoogleMap map;

    public Map() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map_fragment, container, false);
        map = mapFragment.getMap();
        return v;
    }
}
