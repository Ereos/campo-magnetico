package Apartados;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Genera y administra cada uno de los Arrays de los apartados de la simulación práctica.
 *
 */
public class Apartado {

	protected double apartado[][];
	protected int tipo;
    final protected static MathContext escala = new MathContext(5);
	
	/**
	 * El numero de la opción indica que apartado va a ser creado, inicializa el
	 * apartado"opc" indicado.
	 */
	public Apartado(int opc) {
		switch (opc) {
		case 1:
			apartado = Teslamometro.apartado1(0.02);
			break;
		case 2:
			apartado = Teslamometro.apartado2();
			break;
		case 3:
			apartado = Teslamometro.apartado3();
			break;
			
		default:
			apartado = Teslamometro.apartado1(0.02);
			break;
		}
		tipo = opc;
	}
	
	public double getB(double y){
		
		int indice;
		if(tipo==1){
			if(y==0){
				return 0;
			}
			indice = (int) (y/5) - 1;
		}else{
			//y = -0.04 + 0.00025 * i
			indice= (int) ((y + 0.04)/0.0025);
		}
		BigDecimal result = new BigDecimal(apartado[indice][1]).round(escala);
		result = result.multiply(new BigDecimal(1000)).round(escala); //Pasar a miliTeslas
		
		
		return result.setScale(4, RoundingMode.HALF_UP).doubleValue();
		
	}

	public int size() {
		return apartado.length;
	}
	
	public int tipo_apartado(){
		return this.tipo;
	}

}
