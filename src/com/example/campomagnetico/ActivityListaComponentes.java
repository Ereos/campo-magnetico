package com.example.campomagnetico;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ActivityListaComponentes extends Activity {

	protected Intent intent;
	
	private Adapter_Componentes adapterComp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_componentes);
		ListView listaComponentes = (ListView)findViewById(R.id.lvComponentes);
		
		
		adapterComp = new Adapter_Componentes(this,this.CargarComponentes());
		
		listaComponentes.setAdapter(adapterComp);	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	            return true;
	        case R.id.action_inicio:
	            return true;
	        case R.id.action_acercaDe:
	        	intent = new Intent("acerca_de");
	        	startActivity(intent);
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	
	
	/**
	 * Llena un arrayList con los componentes
	 * @return ArrayList <Componente>
	 */
	public ArrayList<Componente> CargarComponentes(){
		
		ArrayList<Componente> losComponentes = new ArrayList<Componente>();

		Componente generador = new Componente("Fuente de alimentación", getString(R.string.DescFAlimentacion), R.drawable.generador_mini, R.drawable.generador);
		losComponentes.add(generador);
		
		Componente cosa = new Componente("Transformador", getString(R.string.DescTransformador), R.drawable.cosa_mini, R.drawable.cosa);
		losComponentes.add(cosa);
		
		Componente amperimetro = new Componente("Amperímetro", getString(R.string.DescAmperimetro), R.drawable.amperimetro_mini, R.drawable.amperimetro);
		losComponentes.add(amperimetro);
		
		Componente pinzas = new Componente("Pinzas", getString(R.string.DescPinzaAmp), R.drawable.pinzas_mini, R.drawable.pinzas);
		losComponentes.add(pinzas);
		
		Componente teslamometro = new Componente("Teslamometro", getString(R.string.DescTeslam), R.drawable.teslamometro_mini, R.drawable.teslamometro);
		losComponentes.add(teslamometro);
		
		Componente SondaHall = new Componente("Sonda Hall", getString(R.string.DescSondaHall), R.drawable.teslamometro_mini, R.drawable.teslamometro);
		losComponentes.add(SondaHall);
		
		Componente conductorA = new Componente("Conductor A", getString(R.string.DescConductorA), R.drawable.conductor_a_mini, R.drawable.conductor_a);
		losComponentes.add(conductorA);
		
		Componente conductorB = new Componente("Conductor B", getString(R.string.DescConductorB), R.drawable.conductor_b_mini, R.drawable.conductor_b);
		losComponentes.add(conductorB);
		
		Componente conductorC = new Componente("Conductor C", getString(R.string.DescConductorC), R.drawable.conductor_c_mini, R.drawable.conductor_c);
		losComponentes.add(conductorC);
		
		Componente circuito = new Componente("Circuito", getString(R.string.DescCircuito), R.drawable.circuito_mini, R.drawable.circuito);
		losComponentes.add(circuito);
		
		return losComponentes;
		
	}

}
