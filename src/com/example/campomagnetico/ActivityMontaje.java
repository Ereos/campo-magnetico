package com.example.campomagnetico;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityMontaje extends Activity {

	protected Intent intent;
	protected ViewGroup vista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_montaje);
		
		vista=(LinearLayout)findViewById(R.id.linearMontaje);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_montaje, menu);
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
	        case R.id.action_aumentar:
	        	recorrerTextView(vista, 0);
	        	return true;
	        	
	        case R.id.action_disminuir:
	        	recorrerTextView(vista, 1);
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	protected void recorrerTextView (ViewGroup parent, int opcion){
		float tamano = 0;
		TextView tvGuion;
		
		for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            final View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                recorrerTextView((ViewGroup) child, opcion);
            } else {
                if (child != null) {
                	if (child instanceof TextView){
                		tvGuion = (TextView)child;
                		
                			tamano = tvGuion.getTextSize();
                    		if (opcion == 0){
                    			tamano++;
                    		}else {
                    			tamano--;
                    		}                		
                		tvGuion.setTextSize(TypedValue.COMPLEX_UNIT_PX, tamano);
                	}
                }
            }
        }
		
		
	}
}
