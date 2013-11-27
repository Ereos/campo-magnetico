package Apartados;

import java.util.ArrayList;

public class Datos {

	protected int apartado;
	protected ArrayList<Medida> arrayDatos;
	
	
	public Datos(int apartado) {
		// TODO Auto-generated constructor stub
		this.apartado = apartado;
	}
	
	public void add_dato(double y, double campo){
		if(apartado <= 1){
			Medida medida = new Medida(y, campo, y*2);
			this.arrayDatos.add(medida);
		}else{//apartado >1
			Medida medida = new Medida(y, campo);
			this.arrayDatos.add(medida);
		}
	}
	
	public ArrayList<Medida> get_array(){
		return arrayDatos;
	}
	
	public Medida get_medida(int indice){
		return arrayDatos.get(indice);
	}
	
	public static void exportar_csv(){
		//TODO Diego
	}

}
