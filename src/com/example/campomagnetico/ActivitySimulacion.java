package com.example.campomagnetico;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

public class ActivitySimulacion extends Activity {
	
	protected Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simulacion);
		
		//Tabs
		Resources res = getResources();
		 
		TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		 
		TabHost.TabSpec spec=tabs.newTabSpec("tab1");
		spec.setContent(R.id.tabConductorA);
		spec.setIndicator("Conductor A", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		 
		spec=tabs.newTabSpec("tab2");
		spec.setContent(R.id.tabConductorB);
		spec.setIndicator("Conductor B", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("tab3");
		spec.setContent(R.id.tabConductorC);
		spec.setIndicator("Conductor C", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		 
		tabs.setCurrentTab(0);
		//Fin Tabs
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_simulacion, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.action_inicio:
	        	onBackPressed();
	            return true;
	        case R.id.action_acercaDe:
	        	intent = new Intent("acerca_de");
	        	startActivity(intent);
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
