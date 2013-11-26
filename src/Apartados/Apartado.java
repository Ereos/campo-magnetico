package Apartados;
/**
 * Genera y administra cada uno de los Arrays de los apartados de la simulación práctica.
 *
 */
public class Apartado {

	protected double apartado[][];
	protected int tipo;
	
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
			indice = (int) (y/5);
		}else{
			//y = -0.04 + 0.00025 * i
			indice= (int) ((y + 0.04)/0.0025);
		}
		
		return apartado[indice][1];
		
	}

	public int size() {
		return apartado.length;
	}

}
