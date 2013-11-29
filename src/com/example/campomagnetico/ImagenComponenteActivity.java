package com.example.campomagnetico;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ImagenComponenteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagen_componente);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.imagen_componente, menu);
		return true;
	}

}
