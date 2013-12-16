package Apartados;

import java.util.ArrayList;

public class GestoraInformacion {
	
	private static ArrayList<Medida> datosA = new ArrayList<Medida>();
	private static ArrayList<Medida> datosB = new ArrayList<Medida>();
	private static ArrayList<Medida> datosC = new ArrayList<Medida>();
	
	private GestoraInformacion (){
		
	}
	
	public static ArrayList<Medida> getDatosA() {
		return datosA;
	}
	public static void setDatosA(ArrayList<Medida> datosA) {
		GestoraInformacion.datosA = datosA;
	}
	public static ArrayList<Medida> getDatosB() {
		return datosB;
	}
	public static void setDatosB(ArrayList<Medida> datosB) {
		GestoraInformacion.datosB = datosB;
	}
	public static ArrayList<Medida> getDatosC() {
		return datosC;
	}
	public static void setDatosC(ArrayList<Medida> datosC) {
		GestoraInformacion.datosC = datosC;
	}
	
	

}
