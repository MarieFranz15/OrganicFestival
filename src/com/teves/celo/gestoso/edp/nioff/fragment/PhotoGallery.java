package com.teves.celo.gestoso.edp.nioff.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.teves.celo.gestoso.edp.nioff.R;

public class PhotoGallery extends Fragment {

	int mFlipping = 0 ; // Initially flipping is off
	Button mButton ; // Reference to button available in the layout to start and stop the flipper

    public PhotoGallery() {

    	
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.photogallery, null);
        /** Click event handler for button */
        OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ViewFlipper flipper = (ViewFlipper) view.findViewById(R.id.flipper1);
				
				if(mFlipping==0){
					/** Start Flipping */
					flipper.startFlipping();
					mFlipping=1;
					mButton.setText("Stop Image Slideshow");
				}
				else{
					/** Stop Flipping */
					flipper.stopFlipping();					
					mFlipping=0;
					mButton.setText("Start Image Slideshow");
				}
			}
		};
		
		/** Getting a reference to the button available in the resource */
        mButton = (Button) view.findViewById(R.id.btn);
        
        /** Setting click event listner for the button */
        mButton.setOnClickListener(listener);
        
        
    
        return view;
    }


}