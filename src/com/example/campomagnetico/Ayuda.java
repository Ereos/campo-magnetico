package com.example.campomagnetico;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.TabHost;

public class Ayuda extends Activity {
	protected Intent intent;
	protected TabHost tabs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ayuda);
		
		//Tabs
		Resources res = getResources();
		tabs = (TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		
		TabHost.TabSpec spec = tabs.newTabSpec("TabAyudaInicio");
		spec.setContent(R.id.AyudaInicio);
		spec.setIndicator(getString(R.string.tabAyuda),res.getDrawable(android.R.drawable.ic_menu_today));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("TabAyudaGuion");
		spec.setContent(R.id.AyudaGuion);
		spec.setIndicator(getString(R.string.bGuionTeoricoSort),res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("TabAyudaComponentes");
		spec.setContent(R.id.AyudaComponentes);
		spec.setIndicator(getString(R.string.bComponetesSort),res.getDrawable(android.R.drawable.ic_dialog_info));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("TabAyudaSimulacion");
		spec.setContent(R.id.AyudaSimulacion);
		spec.setIndicator(getString(R.string.bSimulacionSort),res.getDrawable(android.R.drawable.ic_lock_idle_charging));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("TabAyudaMenu");
		spec.setContent(R.id.AyudaMenu);
		spec.setIndicator(getString(R.string.bMenuDespleg),res.getDrawable(android.R.drawable.ic_menu_add));
		tabs.addTab(spec);

		int activo = getIntent().getIntExtra("tab", 0);
		if(activo <= 4){
			tabs.setCurrentTab(activo);
		}else
			tabs.setCurrentTab(0);
		Log.e(activo + "","activo");
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ayuda, menu);
		return true;
	}

}
