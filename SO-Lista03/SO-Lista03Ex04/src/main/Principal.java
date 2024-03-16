package main;

import controller.Formula1Controller;

public class Principal {

	public static void main(String[] args) {
		int qntCarros = 14;
		int contador = 0, escuderia = 0;
		
		
		for(int i = 0; i < qntCarros; i++){
			Thread ctrl = new Formula1Controller(i, escuderia);
			ctrl.start();
			
			contador++;
			
			if(contador % 2 == 0) {
				escuderia++;
				
			}
		}
		
	}

}
