package com.teves.celo.gestoso.edp.nioff.fragment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.teves.celo.gestoso.edp.nioff.R;

public class Symposia extends Fragment implements OnClickListener {
  Button day1, day2, day3;
    
    public Symposia() {
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.symposia, container,
                false);
        day1 = (Button) rootView.findViewById (R.id.day1);
        day1.setOnClickListener(this);
        day2 = (Button) rootView.findViewById (R.id.day2);
        day2.setOnClickListener(this);
        day3 = (Button) rootView.findViewById (R.id.day3);
        day3.setOnClickListener(this);
	
        return rootView;
    }
	@Override
	public void onClick(View v) {

		  final Dialog dialog1 = new Dialog(getActivity());
		  dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
		  dialog1.setContentView(R.layout.dialog);
		  TextView tv1 = (TextView) dialog1.findViewById(R.id.textScroll);
		  TextView tv4 = (TextView) dialog1.findViewById(R.id.onopra);
			
			tv4.setTextColor(0xAA2ca153);
			String text = readTxt();
		
		        
		    	
		
			
			if(v.getId()== R.id.day1){
				//sString text = Symposia1();
				tv1.setText(text);

					 dialog1.show();
			}
			if(v.getId()== R.id.day2){
				//String text = Symposia1();
				tv1.setText(text);
			        
					 dialog1.show();
			}
			if(v.getId()== R.id.day3){
				
				//String text = Symposia1();
				tv1.setText(text);
					 dialog1.show();
			}
		   
			
		}
	
	
	private String readTxt(){

    	//readspell();
        InputStream inputStream = getResources().openRawResource(R.raw.sked1);
        
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
