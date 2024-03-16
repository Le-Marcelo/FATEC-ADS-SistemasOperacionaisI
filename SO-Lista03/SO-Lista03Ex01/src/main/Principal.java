package main;

import controller.SemaforoController;

public class Principal {

	public static void main(String[] args) {
		
		for(int i = 0; i < 4; i++) {
			Thread ctrl = new SemaforoController(i);
			ctrl.start();
		}

	}

}
