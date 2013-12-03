package com.example.campomagnetico;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		listaComponentes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int posicion,
					long id) {
				Componente pulsado = (Componente) parent.getItemAtPosition(posicion);
				intent = new Intent("imagenComponente");
				intent.putExtra("nombre", "" + pulsado.getNombre());
				intent.putExtra("descripcion", "" + pulsado.getDescripcion());
				intent.putExtra("foto", "" + pulsado.getIdFoto());
				
				startActivity(intent);
				
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_lista_componentes, menu);
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
	
	/**
	 * Llena un arrayList con los componentes
	 * @return ArrayList <Componente>
	 */
	public ArrayList<Componente> CargarComponentes(){
		
		ArrayList<Componente> losComponentes = new ArrayList<Componente>();

		Componente generador = new Componente("Fuente de alimentación", getString(R.string.DescFAlimentacion), R.drawable.generador_mini, R.drawable.generador);
		losComponentes.add(generador);
		
		Componente cosa = new Componente("Transformador", getString(R.string.DescTransformador), R.drawable.transformador_mini, R.drawable.transformador);
		losComponentes.add(cosa);
		
		Componente amperimetro = new Componente("Amperímetro", getString(R.string.DescAmperimetro), R.drawable.amperimetro_mini, R.drawable.amperimetro);
		losComponentes.add(amperimetro);
		
		Componente pinzas = new Componente("Pinzas", getString(R.string.DescPinzaAmp), R.drawable.pinzas_mini, R.drawable.pinzas);
		losComponentes.add(pinzas);
		
		Componente teslamometro = new Componente("Teslamometro", getString(R.string.DescTeslam), R.drawable.teslametro_mini, R.drawable.teslametro);
		losComponentes.add(teslamometro);
		
		Componente SondaHall = new Componente("Sonda Hall", getString(R.string.DescSondaHall), R.drawable.teslametro_mini, R.drawable.teslametro);
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
