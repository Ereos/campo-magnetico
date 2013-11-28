package Apartados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.os.Environment;

public class Datos {

	protected int apartado;
	protected ArrayList<Medida> arrayDatos;
	
	
	public Datos(int apartado) {
		// TODO Auto-generated constructor stub
		this.apartado = apartado;
		this.arrayDatos = new ArrayList<Medida>();
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
	
	public void exportar_csv(){
		
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss_dd-MM-yyyy");
		String fecha = formato.format(cal.getTime());
		
		
		File rutaSD = new File(Environment.getExternalStorageDirectory().toString());
		File rutaCarpeta = new File(rutaSD+"/SimuCampoMagnetico");
		File rutaArchivo = new File(rutaCarpeta+"Apartado"+apartado+fecha+".csv");
		
		if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			//No esta presente la SD card o no se puede escribir
		}else if (rutaCarpeta.isFile()){
			//Hay un archivo presente en la SDcard que no es una carpeta
		}else if (!rutaArchivo.mkdirs()){
			//No se ha podido crear	
		}else{
			try {
				FileWriter escritor = new FileWriter(rutaArchivo);
				escritor.write(crearCSV());
				escritor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private String crearCSV(){
		
		if (apartado==1){
			String cadenaDatos = "Intensidad(mA),Intensidad_C(A),Campo(T)\n";
			for (Medida item: arrayDatos){
				
				cadenaDatos += item.valor1+","+item.valorIc+","+item.valor2+"\n";
			}
			
			return cadenaDatos;
		}else{
			String cadenaDatos = "Intensidad(mA),Campo(T)\n";
			for (Medida item: arrayDatos){
				
				cadenaDatos += item.valor1+","+item.valor2+"\n";
			}
			return cadenaDatos;	
		}
	}
}
