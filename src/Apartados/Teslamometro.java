package Apartados;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;

public class Teslamometro {
        /**
         * Permeabilidad magnética en el vacio.
         */
        final public static double permeabilidad = 12.56E-7;//T*m/A
        final protected static MathContext escala = new MathContext(5);
        
        /**
         * Calcula el campo magnético a partir de la ecuación B=mu*I/2*Pi*r
         * @param intensidad Intensidad de la corriente en el conductor.
         * @param distancia Distancia 'r' del conductor al punto de medida.
         * @return Valor del campo magnético en el punto indicado.
         */
        public static double calcula_campo(double intensidad, double distancia){
                return (permeabilidad * intensidad)/(2* Math.PI* distancia);
        }
        
        /**
         * Calcula el campo magnético generado por dos conductores rectilineosseparados una 
         * distancia "d" en un punto "y" y cuya intensidad tiene el mismo sentido.
         * @param intensidad Intensidad de corriente que circula por el conductor.
         * @param y Distancia del conductor 1 al punto en el que se va a hacer la medicion.
         * @param d distancia entre los dos conductores.
         * @return Valor del campo magnético en el punto indicado.
         */
        public static double calcula_campo(double intensidad, double y, double d){
        	double campo1 = 0, campo2 = 0;
        	if(y != 0 && y != d){ //B = B1 + B2 
	        	campo1 = calcula_campo(intensidad, y);
	        	if(y < d){//siendo r= y-d
	        		campo2 = calcula_campo(intensidad, y-d);
	        	}else{ // siendo r= y+d
	        		campo2 = calcula_campo(intensidad, y+d);
	        	}
        	}else if(y == 0){ //B = B2
        		campo2 = calcula_campo(intensidad, y-d);
        	}else{//B=B1
	        	campo1 = calcula_campo(intensidad, y);
        	}
    		return campo1 + campo2;
        }
        
        /**
         * Calcula el campo magnético generado por dos conductores cuya intensidad tiene distinta
         * dirección y sentido, separados una distancia "d" en un punto "y".
         * @param intensidad Intensidad de corriente que circula por el conductor.
         * @param y Distancia del conductor 1 al punto en el que se va a hacer la medicion.
         * @param d distancia entre los dos conductores.
         * @return Valor del campo magnético en el punto indicado.
         */
        public static double calcula_campo_inverso(double intensidad, double y, double d){
        	double campo1 = 0, campo2 = 0;
        	if(y != 0 & y != d){
	        	campo1 = calcula_campo(intensidad, y);
	        	if(y < d){
	        		campo2 = calcula_campo(-intensidad, y-d);
	        	}else{
	        		campo2 = calcula_campo(-intensidad, y+d);
	        	}
        	}else if(y == 0){
        		campo2 = calcula_campo(-intensidad, y-d);
        	}else{
	        	campo1 = calcula_campo(intensidad, y);
        	}
    		return campo1 + campo2;
        }
        /**
         * En el primer apartado se calcula el campo magnético generado por un conductor recto
         * por el que pasa una corriente variable a una distancia constante del conductor.
         * La intensidad varia de 5mA a 50mA en intervalos de 5 mA.
         * @param distancia Constante que indica la distancia del conductor rigido al punto de medición
         * @return Un array bidimensional [intensidad I(mA)][CampoMagnetico B(mT)].
         */
        public static double[][] apartado1(double distancia){
        	double result[][] = new double[10][2];
        	Integer i;
        	BigDecimal intensidad;
    		for(i=0;i<10;i++){
    			intensidad = new BigDecimal((double)0.005 * (double)(i+1));
    			result[i][0]= intensidad.doubleValue(); // Paso a Amperios
    			result[i][1]=Teslamometro.calcula_campo(amplifica(intensidad), 0.02); 
    		}
        	
			return result;
        }
        
        /**
         * En el segundo apartado se fija la corriente del circuito a un valor Ic = 100A
         * Variará "y" en intervalos de 0.25 y se calculará el campo "B" generado por el
         * confuctor B un conductor con dos hilos rectilineos cercanos, separados una 
         * distancia de 6,5 centimetros, intensidades de corriente con el mismo sentido.
         * @return Un array bidimensional [57][2] cuyo indice 0 es "y" y su inidice 1 es "B"
         */
        public static double[][] apartado2(){
        	int i = 0; 
        	final BigDecimal intensidad = new BigDecimal(100); //100Amperios
        	double campo,campo2;
        	BigDecimal y = new BigDecimal(-0.0425).round(escala);//de -4cm a 10cm en intervalos de 0.25 cm
        	BigDecimal intervalo = new BigDecimal(0.0025).round(escala);
        	double result[][] = new double[57][2];
        	final BigDecimal d = new BigDecimal(0.065);//Distancia entre las dos barras del conductor (m).
        	while(y.doubleValue() < 0.1){
        		y = y.add(intervalo);
        		result[i][0] = y.setScale(5).doubleValue();
       			result[i][1] = calcula_campo(amplifica(intensidad), y.doubleValue(), d.doubleValue());
       			i++;
        	}
			return result;
        }
        
        /**
         * 
         * 
         * En el tercer apartado se mantendrá una corriente constante , en el conductor C
         * a un valor Ic= 100A, en el cual variará la distancia de medida "y" y se calculará 
         * el campo en ese punto.
         * El conductor C es un conductor rectilineo en forma de rectangulo, cuya distancia
         * entre los dos conductores más largos es de 6,5 centimetros, y las intensidades
         * de corriente tienen distinto sentido.
         * @return
         */
        public static double[][] apartado3(){
        	int i = 0; //de -4 a 10 en intervalos de 0.25
        	final BigDecimal intensidad = new BigDecimal(100); //100Amperios
        	double campo,campo2;
        	BigDecimal y = new BigDecimal(-0.0425), intervalo = new BigDecimal(0.0025);
        	double result[][] = new double[57][2];
        	final BigDecimal d = new BigDecimal (0.065);//Distancia entre las dos barras del conductor (m).
        	while(y.doubleValue() < 0.1){
        		y = y.add(intervalo); 
        		result[i][0] = y.doubleValue();
       			result[i][1] = calcula_campo_inverso(amplifica(intensidad), y.doubleValue(), d.doubleValue());
       			i++;
        	}
			return result;
        }

        /**
         * Realiza el cambio de medidas, de la dada por la pinza amperímetra al valor
         * real, puesto que la pinza magnética amperimétrica utilizada es reductora, 
         * por lo tarnto Ic = 2000 * I.
         * @return  2000 * I
         */
        public static double amplifica(BigDecimal I){
        	//Ic = 2000 * I
			return I.multiply(new BigDecimal(2000)).doubleValue(); //Ic
        	
        }
}
