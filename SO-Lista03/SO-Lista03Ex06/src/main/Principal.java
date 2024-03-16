package main;

import controller.JogoController;

public class Principal {

	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			Thread ctrl = new JogoController(i);
			ctrl.start();
		}
	}

}
