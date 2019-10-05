package com.teves.celo.gestoso.edp.nioff.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.teves.celo.gestoso.edp.nioff.R;
public class OrganicFarmTour extends Fragment implements View.OnClickListener{
 Button nloop, cloop, sloop;
    
    public OrganicFarmTour() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.organicfarmtour, container,
                false);
        nloop = (Button) rootView.findViewById (R.id.nloop);
        nloop.setOnClickListener(this);
        cloop = (Button) rootView.findViewById (R.id.cloop);
        cloop.setOnClickListener(this);
        sloop = (Button) rootView.findViewById (R.id.sloop);
        sloop.setOnClickListener(this);
	
        return rootView;
    }
	@Override
	public void onClick(View v) {

		  final Dialog dialog1 = new Dialog(getActivity());
		  dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
		  dialog1.setContentView(R.layout.organictour);
		  TextView text = (TextView) dialog1.findViewById(R.id.LoopName);
		
			if(v.getId()== R.id.nloop){
				  text.setText("The Northern Loop");
				  TouchImageView img = (TouchImageView) dialog1.findViewById(R.id.mapView);
			        img.setImageResource(R.drawable.northernloop);
			        img.setMaxZoom(4f);
			        
					 dialog1.show();
			}
			if(v.getId()== R.id.cloop){
				  text.setText("The Central Loop");
				  TouchImageView img = (TouchImageView) dialog1.findViewById(R.id.mapView);
			        img.setImageResource(R.drawable.centralloop);
			        img.setMaxZoom(4f);
			        
					 dialog1.show();
			}
			if(v.getId()== R.id.sloop){
				  text.setText("The Southern Loop");
				  TouchImageView img = (TouchImageView) dialog1.findViewById(R.id.mapView);
			        img.setImageResource(R.drawable.southernloop);
			        img.setMaxZoom(4f);
			        
					 dialog1.show();
			}
		   
			
		}

	
}



