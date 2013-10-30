package com.example.campomagnetico;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {	

	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Componentes
		final Button bGuion = (Button)findViewById(R.id.bGuion);
		final Button bMontaje = (Button)findViewById(R.id.bMontaje);
		final Button bComponentes = (Button)findViewById(R.id.bComponentes);
		final Button bSimulacion = (Button)findViewById(R.id.bSimulacion);

		
		bGuion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				intent = new Intent("guion");
				startActivity(intent);
			}
		});
		
		bMontaje.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				intent = new Intent("montaje");
				startActivity(intent);
				
			}
		});
		
		bComponentes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				intent = new Intent("componentes");
				startActivity(intent);
			}
		});
		
		bSimulacion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				intent = new Intent("simulacion");
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
