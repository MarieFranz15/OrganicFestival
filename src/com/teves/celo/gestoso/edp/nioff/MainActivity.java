package com.teves.celo.gestoso.edp.nioff;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.teves.celo.gestoso.edp.nioff.fragment.AboutFestival;
import com.teves.celo.gestoso.edp.nioff.fragment.Committees;
import com.teves.celo.gestoso.edp.nioff.fragment.ContactSecretariat;
import com.teves.celo.gestoso.edp.nioff.fragment.EventMap;
import com.teves.celo.gestoso.edp.nioff.fragment.EventsandActivities;
import com.teves.celo.gestoso.edp.nioff.fragment.OrganicFarmTour;
import com.teves.celo.gestoso.edp.nioff.fragment.PhotoGallery;
import com.teves.celo.gestoso.edp.nioff.fragment.Symposia;
import com.teves.celo.gestoso.edp.nioff.fragment.SocialMedia;
import com.teves.celo.gestoso.edp.nioff.layout.MainLayout;

// DK 
// This is my studying about Sliding Menu following Youtube video
public class MainActivity extends FragmentActivity {

    // The MainLayout which will hold both the sliding menu and our main content
    // Main content will holds our Fragment respectively
    MainLayout mainLayout;
    
    // ListView menu
    private ListView lvMenu;
    private String[] lvMenuItems;
    
    // Menu button
    Button btMenu;
    
    // Title according to fragment
    TextView tvTitle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Inflate the mainLayout
        mainLayout = (MainLayout)this.getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(mainLayout);
        
        // Init menu
        
        lvMenuItems = getResources().getStringArray(R.array.menu_items);
        
        lvMenu = (ListView) findViewById(R.id.activity_main_menu_listview);
        lvMenu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lvMenuItems));
        lvMenu.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }
            
        });
        
        
        // Get menu button
        btMenu = (Button) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                toggleMenu(v);
            }
        });
        
        // Get title textview
        tvTitle = (TextView) findViewById(R.id.activity_main_content_title);
        
        
        // Add FragmentMain as the initial fragment       
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        Committees fragment = new Committees();
        ft.add(R.id.activity_main_content_fragment, fragment);
        ft.commit();   
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void toggleMenu(View v){
        mainLayout.toggleMenu();
    }
    
    // Perform action when a menu item is clicked
    private void onMenuItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = lvMenuItems[position];
        String currentItem = tvTitle.getText().toString();
        
        // Do nothing if selectedItem is currentItem
        if(selectedItem.compareTo(currentItem) == 0) {
            mainLayout.toggleMenu();
            return;
        }
            
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;

        
        if(selectedItem.compareTo("Main") == 0) {
            fragment = new Committees();
        } else if(selectedItem.compareTo("About the Festival") == 0) {
            fragment = new AboutFestival();
        } else if(selectedItem.compareTo("Events, Seminars and  Activities") == 0) {
            fragment = new EventsandActivities();
        } else if(selectedItem.compareTo("Symposia") == 0) {
            fragment = new Symposia();
        } else if(selectedItem.compareTo("Event Map") == 0) {
            fragment = new EventMap();
        } else if(selectedItem.compareTo("Organic Farm Tour") == 0) {
            fragment = new OrganicFarmTour();
        } else if(selectedItem.compareTo("Committees") == 0) {
            fragment = new Committees();
        } else if(selectedItem.compareTo("Photo Gallery") == 0) {
            fragment = new PhotoGallery();
         /*   Bundle b = new Bundle();
            b.putString("KEY_STRING", "Please display this text");
            fragment.setArguments(b)*/
        } else if(selectedItem.compareTo("Social Media") == 0) {
            fragment = new SocialMedia();
        
	    } else if(selectedItem.compareTo("Contact Secretariat") == 0) {
	        fragment = new ContactSecretariat();
	    }
        
        if(fragment != null) {
            // Replace current fragment by this new one
            ft.replace(R.id.activity_main_content_fragment, fragment);
            ft.commit();
            
            // Set title accordingly
            tvTitle.setText(selectedItem);
        }
        
        // Hide menu anyway
        mainLayout.toggleMenu();
    }
    
    @Override
    public void onBackPressed() {
        if (mainLayout.isMenuShown()) {
            mainLayout.toggleMenu();
        }
        else {
            super.onBackPressed();
        }
    }
}
