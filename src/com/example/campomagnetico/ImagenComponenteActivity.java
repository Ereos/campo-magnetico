package com.example.campomagnetico;

import java.math.BigDecimal;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImagenComponenteActivity extends Activity {

	private Intent intent;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagen_componente);
		
		/** Se recogen los valores enviados desde otro activity*/
		String nombre = getIntent().getStringExtra("nombre");
		String desc = getIntent().getStringExtra("descripcion");
		String img = getIntent().getStringExtra("foto");
		/** Se tratan esos valores para su uso*/
		int iimg = Integer.parseInt(img);
		/** Se editan el imageView, el Titulo y la descripción con los valores recibidos*/
		ImageView imagenMostrada = (ImageView) findViewById(R.id.imagenComponente);
		imagenMostrada.setImageDrawable(getResources().getDrawable(iimg));
		setTitle(getTitle() +" " + nombre);
		TextView descView = (TextView) findViewById(R.id.imagenDescripcion);
		descView.setText(desc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.imagen_componente, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		TextView descView = (TextView) findViewById(R.id.imagenDescripcion);
		BigDecimal tamanyo , aumento = new BigDecimal(20);
		Toast toast;
	    switch (item.getItemId()) {
    		case R.id.action_aumentar:
    			tamanyo = new BigDecimal(descView.getTextSize());
    			//Aun no esta bien implementado
    			tamanyo = tamanyo.add(aumento);
    			descView.setTextSize(tamanyo.floatValue());
    			return true;
    		case R.id.action_disminuir:
    			tamanyo = new BigDecimal(descView.getTextSize());
    			//Aun no esta bien implementado
    			tamanyo = tamanyo.subtract(aumento);
    			descView.setTextSize(tamanyo.floatValue());
    			return true;
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
