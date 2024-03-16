package view;

import javax.swing.JOptionPane;

import controller.FilaController;
import model.Fila;

public class Principal {

	public static void main(String[] args) {
		
		Fila<String> filaPadrao = new Fila<>();
		Fila<String> filaPrioritaria = new Fila<>();
		FilaController ctrl = new FilaController();
		
		int opcao;
		
		do {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu\n"
																   + "1- Inserir nova senha.\n"
																   + "2- Inserir nova senha prioritária\n"
																   + "3- Chamar próxima senha\n"
																   + "9- Sair"));
			
			switch(opcao) {
				case 1:
					ctrl.novoElemento(filaPadrao);
					break;
					
				case 2:
					ctrl.novoElemento(filaPrioritaria);
					break;
					
				case 3:
					ctrl.chamarProximo(filaPadrao, filaPrioritaria);
					break;
					
				case 9:
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
					
			}
			
		}while(opcao != 9);
	}

}
