package Apartados;

public class Medida {

	double valor1;
	double valor2;
	double valorIc;
	int apartado;
	
	/**
	 * Creador de una medida realizada para los apartados 2 y 3.
	 * @param valor1 Distancia de medida.
	 * @param valor2 Campo magnético resultante en el punto.
	 */
	public Medida(double valor1, double valor2) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.apartado = 2;
	}
	/**
	 * Constructor de Medida realizada en el apartado 1.
	 * @param valor1 Valor de la intensidad marcado por la pinza amperimétrica reductora (mA).
	 * @param valor2 Campo magnético calculado en el punto (mT).
	 * @param valorIc Valor de la intensidad real que pasa por el circuito (A).
	 */
	public Medida(double valor1, double valor2, double valorIc) {
		super();
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valorIc = valorIc;
		this.apartado = 1;
	}
	
	public double[] get(){
		if(apartado <= 1){
			double result[] = new double[2];
			result[0] = valor1;
			result[1] = valor2;
			return result;
		}else{
			double result[] = new double[3];
			result[0] = valor1;
			result[1] = valor2;
			result[2] = valorIc;
			return result;
		}
	}

	public double getValor1() {
		return valor1;
	}

	public double getValor2() {
		return valor2;
	}
	
	public double get_apartado(){
		return apartado;
	}
	/**
	 * Devuelve el valor de la corriente en Amperios
	 * @requiere Si el apartado es 1, devuelve valor, sino devuelve null.
	 */
	public Double getValorIc() {
		if(this.apartado ==1){
			return valorIc;
		}
		return null;
	}

}
