package main;

import controller.BancoController;

public class Principal {

	public static void main(String[] args) {
		int idConta, saldo, valor, tipo;
		
		for(int i = 0; i < 20; i++) {
			idConta = (int) (Math.random() * 49 + 1);
			saldo = (int) (Math.random() * 10000);
			valor = (int) (Math.random() * 10000);
			tipo = (int) (Math.random() * 9 + 1);
			Thread ctrl = new BancoController(idConta, saldo, valor, tipo);
			ctrl.start();
		}

	}

}
