package com.teves.celo.gestoso.edp.nioff.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.teves.celo.gestoso.edp.nioff.R;

public class CopyOfContactSecretariat extends Fragment {
    WebView webView;
    
    public CopyOfContactSecretariat() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact, null);
    
        webView = (WebView) view.findViewById(R.id.fragment_webview_webview);
        webView.setBackgroundColor(0);
        String data = "<html><body><h1>9TH NEGROS ISLAND ORGANIC FARMERS FESTIVAL</h1>" +
        		"</br> <style:font-size='130px'> <b> Organic Festival Secretariat:</b></br> </style>" +
        		"Provincial Soils Laboratory Center</br> " +
        		"Office of the Provincial Agriculturist </br> Negros Occidental</br> " +
        		"<i> Email Address: </i> oaneg.occ@gmail.com </br>" +
        		"<i> Phone: </i> +63(034) 433-9853 </br> </br> </br> " +
        		
        		"<b> Contact Persons:</br> </b> " +
        		"<i> Lida Barrogo (Mobile)  </i> +63921-748-6840 </br>" +
        		"<i> Gabriel Advincula (Mobile) </i>  +63917-313-1980 </br> </br> </br> " +
        		"" +
        		"" +
        		"</body>" +
        		
"</html>";
        webView.loadDataWithBaseURL("", data, "text/html", "UTF-8", "");
        
        return view;
    }
}
