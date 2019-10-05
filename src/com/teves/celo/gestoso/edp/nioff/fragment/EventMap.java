package com.teves.celo.gestoso.edp.nioff.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teves.celo.gestoso.edp.nioff.R;

import com.teves.celo.gestoso.edp.nioff.fragment.TouchImageView;;

public class EventMap extends Fragment {
    
    public EventMap() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_map, null);
        TouchImageView img = (TouchImageView) view.findViewById(R.id.mapView);
        img.setImageResource(R.drawable.eventmap);
        img.setMaxZoom(4f);
        
        return view;
    }
}
