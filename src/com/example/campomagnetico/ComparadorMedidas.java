package com.example.campomagnetico;

import java.util.Comparator;

import Apartados.Medida;

/**
 * Clase que se encarga de ordenar los datos por el Campo1
 * 
 *
 */
public class ComparadorMedidas implements Comparator<Medida>{

	@Override
	public int compare(Medida o1, Medida o2) {
		if (o1.getValor1() > o2.getValor1()){
			
            return 1;
		}
		else if (o1.getValor1() < o2.getValor1())
        {
           return -1;
        }
       return 0; 
	}
}
