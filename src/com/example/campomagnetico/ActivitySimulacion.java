package com.example.campomagnetico;

import java.math.MathContext;

import Apartados.Apartado;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TabHost;
import android.widget.TextView;

public class ActivitySimulacion extends Activity {
	
	protected Intent intent;
	/** Un seekBar por apartado*/
	protected SeekBar seekbarA;
	protected SeekBar seekbarB;
	protected SeekBar seekbarC;

	/** Un Textview por seekbar */
	protected TextView seektextA;
	protected TextView seektextB;
	protected TextView seektextC;
	
	/** Un Textview por apartado*/
	protected TextView tesla1;
	protected TextView tesla2;
	protected TextView tesla3;
	
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
		
		//Inicializacion de teslamometros
		final Apartado apartado1 = new Apartado(1);
		final Apartado apartado2 = new Apartado(2);
		final Apartado apartado3 = new Apartado(3);
		
		//Fin Teslamometros
		
		//Seekbars y sus textview asociados

		seekbarA = (SeekBar) findViewById(R.id.seekBarA);
		seektextA = (TextView) findViewById(R.id.textSeekA);
		tesla1 = (TextView) findViewById(R.id.Tesla1);
		seekbarA.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			/**
			  * Evento encargado del control del estado del seekbar
			  */
			 public void onProgressChanged(SeekBar seekBar, int progress,
			    		boolean fromUser) {
					
			    	// TODO Añadir una variable global que tenga el contenido?
					seektextA.setText("" + (progress*5) + " mA");
					if(progress == 0){
						tesla1.setText("0 (T)");
					}else{
						tesla1.setText(""+ apartado1.getB(progress*5) + " (mT)");
					}
			    }

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// Nada que hacer
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// Nada que hacer
				
			}
			
		});
		/* Seek aún no creados TODO
		seekbarB = (SeekBar) findViewById(R.id.seekBarB);
		seektextB = (TextView) findViewById(R.id.textSeekB);
		seekbarC = (SeekBar) findViewById(R.id.seekBarC);
		seektextC = (TextView) findViewById(R.id.textSeekC);*/
		//Fin SeekViews		
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
