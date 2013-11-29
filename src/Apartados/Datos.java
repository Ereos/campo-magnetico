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
	
	/**
	 * Genera un nuevo contenido con Datos de un "apartado" determinado.
	 * @param apartado Número del apartado al que serán dedicados los Datos.
	 */
	public Datos(int apartado) {
		// TODO Auto-generated constructor stub
		this.apartado = apartado;
		this.arrayDatos = new ArrayList<Medida>();
	}
	/**
	 * Añade una Medida al conjunto de datos.
	 * Es responsabilidad del usuario de esta clase, que
	 * la el apartado al que corresponde la medida coincida
	 * con el apartado de los Datos.
	 * @param medida Medida con el mismo apartado que los Datos
	 */
	public void add_dato(Medida medida){
		//TODO comprobar si esta la medida.
		this.arrayDatos.add(medida);
	}
	
	/**
	 * Permite añadir los dos valores correspondientes a una medida al registro de Datos.
	 * @param y Valor de la distancia (cm) o intensidad (mA) dependiendo del apartado de los Datos.
	 * @param campo Valor del campo magnético correspondiente al valor "y".
	 */
	public void add_dato(double y, double campo){
		if(apartado <= 1){
			Medida medida = new Medida(y, campo, y*2);
			this.arrayDatos.add(medida);
		}else{//apartado >1
			Medida medida = new Medida(y, campo);
			this.arrayDatos.add(medida);
		}
	}
	/**
	 * 
	 * @return Array de medidas de los Datos de un apartado indicado.
	 */
	public ArrayList<Medida> get_array(){
		return arrayDatos;
	}
	/**
	 * A partir del indice devuelve el valor de la medida correspondiente  
	 * @param indice Numero correspondiente a la posicion de la
	 * @return
	 */
	public Medida get_medida(int indice){
		//TODO control de errores
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
			//TODO No esta presente la SD card o no se puede escribir
		}else if (rutaCarpeta.isFile()){
			//TODO Hay un archivo presente en la SDcard que no es una carpeta
		}else if (!rutaArchivo.mkdirs()){
			// TODO No se ha podido crear	
		}else{
			try {
				FileWriter escritor = new FileWriter(rutaArchivo);
				escritor.write(crearCSV());
				escritor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Genera la cadena de caracteres necesaria para la creación de un archivo CSV estandar.
	 * @return String con todas las medidas de los Datos, siguiendo el estandar de los archivos CSV.
	 */
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
