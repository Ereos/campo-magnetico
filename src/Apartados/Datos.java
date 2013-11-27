package Apartados;

import java.util.ArrayList;

public class Datos {

	protected int apartado;
	protected ArrayList<Medida> arrayDatos;
	
	
	public Datos(int apartado) {
		// TODO Auto-generated constructor stub
		this.apartado = apartado;
	}
	/**
	 * Es responsabilidad del usuario de esta clase, que
	 * la el apartado al que corresponde la medida coincida
	 * con el apartado de los Datos.
	 * @param medida Medida con el mismo apartado que los Datos
	 */
	public void add_dato(Medida medida){
		//TODO comprobar si esta la medida.
		this.arrayDatos.add(medida);
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
