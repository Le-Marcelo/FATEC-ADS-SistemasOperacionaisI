package view;

import java.io.IOException;

import controller.ArquivoController;

public class Principal {

	public static void main(String[] args) {
		ArquivoController ctrl = new ArquivoController();
		String path = "D:\\Área de Trabalho";
		String nome = "generic_food.csv";
		
		try {
			ctrl.lerArquivo(path, nome);
			
		} catch (IOException e) {
			e.getMessage();
			
		}

	}

}
