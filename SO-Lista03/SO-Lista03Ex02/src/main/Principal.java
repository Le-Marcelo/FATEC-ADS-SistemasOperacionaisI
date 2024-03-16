package main;

import controller.CorredorController;

public class Principal {

	public static void main(String[] args) {
		int distancia = 200;
		int velocidadeMinima = 4;
		int velocidadeMaxima = 6;
		
		for(int i = 0; i < 4; i++) {
			Thread ctrl = new CorredorController(i, distancia, velocidadeMinima, velocidadeMaxima);
			ctrl.start();
		}

	}

}
