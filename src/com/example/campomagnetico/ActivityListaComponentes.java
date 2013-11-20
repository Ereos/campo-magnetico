package com.example.campomagnetico;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class ActivityListaComponentes extends Activity {

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
		getMenuInflater().inflate(R.menu.activity_lista_componentes, menu);
		return true;
	}
	
	
	
	/**
	 * Llena un arrayList con los componentes
	 * @return ArrayList <Componente>
	 */
	public ArrayList<Componente> CargarComponentes(){
		
		ArrayList<Componente> losComponentes = new ArrayList<Componente>();
		
		Componente amperimetro = new Componente("Amper’metro", "des", R.drawable.amperimetro_mini, R.drawable.amperimetro);
		losComponentes.add(amperimetro);
		
		Componente circuito = new Componente("Circuito", "des", R.drawable.circuito_mini, R.drawable.circuito);
		losComponentes.add(circuito);
		
		Componente conductorA = new Componente("Conductor A", "des", R.drawable.conductor_a_mini, R.drawable.conductor_a);
		losComponentes.add(conductorA);
		
		Componente conductorB = new Componente("Conductor B", "des", R.drawable.conductor_b_mini, R.drawable.conductor_b);
		losComponentes.add(conductorB);
		
		Componente conductorC = new Componente("Conductor C", "des", R.drawable.conductor_c_mini, R.drawable.conductor_c);
		losComponentes.add(conductorC);
		
		Componente cosa = new Componente("cosa", "des", R.drawable.cosa_mini, R.drawable.cosa);
		losComponentes.add(cosa);
		
		Componente generador = new Componente("Generador", "des", R.drawable.generador_mini, R.drawable.generador);
		losComponentes.add(generador);
		
		Componente pinzas = new Componente("Pinzas", "des", R.drawable.pinzas_mini, R.drawable.pinzas);
		losComponentes.add(pinzas);
		
		Componente teslamometro = new Componente("Teslamometro", "des", R.drawable.teslamometro_mini, R.drawable.teslamometro);
		losComponentes.add(teslamometro);
		
		return losComponentes;
		
	}

}
