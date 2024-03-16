package main;

import controller.BancoController;

public class Principal {

	public static void main(String[] args) {

		for(int i = 1; i <= 21; i++) {
			Thread ctrl = new BancoController(i);
			ctrl.start();
		}

	}

}
