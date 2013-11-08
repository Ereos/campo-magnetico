package Apartados;
import java.text.NumberFormat;

public class Teslamometro {
        /**
         * Permeabilidad magnética en el vacio.
         */
        final public static double permeabilidad = 12.56E-7;//T*m/A
        
        
        /**
         * Calcula el campo magn�tico a partir de la ecuaci�n B=mu*I/2*Pi*r
         * @param intensidad Intensidad de la corriente en el conductor.
         * @param distancia Distancia 'r' del conductor al punto de medida.
         * @return Valor del campo magnético en el punto indicado.
         */
        public static double calcula_campo(double intensidad, double distancia){
                return (permeabilidad * intensidad)/(2* Math.PI* distancia);
        }
        
        /**
         * Calcula el campo magnético generado por dos conductores separados una distancia "d"
         * en un punto "y".
         * @param intensidad Intensidad de corriente que circula por el conductor.
         * @param y Distancia del conductor 1 al punto en el que se va a hacer la medicion.
         * @param d distancia entre los dos conductores.
         * @return Valor del campo magnético en el punto indicado.
         */
        public static double calcula_campo(double intensidad, double y, double d){
        	double campo1, campo2;
        	campo1 = calcula_campo(intensidad, y);
        	if(y <= d){
        		campo2 = calcula_campo(intensidad, y-d);
        	}else{
        		campo2 = calcula_campo(intensidad, y+d);
        	}
        	NumberFormat yx = NumberFormat.getInstance();
        	yx.setMaximumFractionDigits(4); //4 decimales
        	System.out.println("Y"+yx.format(y)+"\t"+"Campo1\t"+yx.format(campo1)+"\t+\tCampo2\t"
        						+yx.format(campo2)+"\t=\t"+yx.format(campo1+campo2));
        		return campo1 + campo2;
        }
        /**
         * En el primer apartado se calcula el campo magnético generado por un conductor recto
         * por el que pasa una corriente variable a una distancia constante del conductor.
         * La intensidad varia de 5mA a 50mA en intervalos de 5 mA.
         * @param distancia Constante que indica la distancia del conductor rigido al punto de medición
         * @return Un array bidimensional [intensidad][CampoMagnetico].
         */
        public static double[][] apartado1(double distancia){
        	double result[][] = new double[10][2];
        	Integer i;
        	double intensidad;
    		for(i=0;i<10;i++){
    			intensidad = (double)0.005 * (double)(i+1);
    			result[i][0]= intensidad;
    			result[i][1]=Teslamometro.calcula_campo(intensidad, 0.02);
    		}
        	
			return result;
        }
        
        
        public static double[][] apartado2(){
        	int i; //de -4 a 10 en intervalos de 0.5
        	final int intensidad = 100; //100Amperios
        	double campo,campo2;
        	double y = -0.04;
        	final double d = 0.065;//Distancia entre las dos barras del conductor (m).
        	while(y < 0.1){
        		if(y < -0.010){//de -0.04 hasta -0.010 en intervalos de 0.005
        			calcula_campo(intensidad, y, d);
        			y += 0.005; 
        		}else if(y <= 0){// de -0.010 hasta 0 en intervalos de 0.0025
        			calcula_campo(intensidad, y, d);
        			y += 0.0025; 
        		}else if(y<= 0.0425){
        			calcula_campo(intensidad, y, d);
        			y += 0.0025; 
        		}
        	}
			return null;
        	
        }
}
