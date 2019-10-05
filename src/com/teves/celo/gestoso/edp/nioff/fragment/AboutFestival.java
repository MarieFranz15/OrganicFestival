package com.teves.celo.gestoso.edp.nioff.fragment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teves.celo.gestoso.edp.nioff.R;

public class AboutFestival extends Fragment {
 
    
    public AboutFestival() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_festival, null);
    	
        readTxt();
		String text = readTxt();
	
	        
	    	
	
		TextView tv1 = (TextView) view.findViewById(R.id.textScroll);
		tv1.setText(text);

		
		TextView tv4 = (TextView) view.findViewById(R.id.onopra);
		tv4.setTextColor(0xAA2ca153);
		
        return view;
    }
    
		
	
	private String readTxt(){

    	//readspell();
        InputStream inputStream = getResources().openRawResource(R.raw.aboutnof);
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        int i;
     try {
   	  i = inputStream.read();
   	  while (i != -1)
         	{
   		  byteArrayOutputStream.write(i);
   		  i = inputStream.read();
         	}
         inputStream.close();
     	} catch (IOException e) {
      // TODO Auto-generated catch block
   	  e.printStackTrace();
     	}
     
        return byteArrayOutputStream.toString();
       }

}
