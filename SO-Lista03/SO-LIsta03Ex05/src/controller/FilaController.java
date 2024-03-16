package controller;

import javax.swing.JOptionPane;

import model.Fila;

public class FilaController {

	private static int contador = 0;
	
	public FilaController() {
		super();
	}
	
	public void novoElemento(Fila<String> fila) {
		String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		fila.insert(nome);
	}

	public void chamarProximo(Fila<String> filaPadrao, Fila<String> filaPrioritaria){
		
		String nome = "";
		
		try {
			if(filaPrioritaria.isEmpty()) {
				nome = filaPadrao.remove();
				
			}else if(contador < 3){
				nome = filaPrioritaria.remove();
				contador++;
				
			}else {
				nome = filaPadrao.remove();
				contador = 0;
				
			}
			
			JOptionPane.showMessageDialog(null, "O próximo cliente é: " + nome);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}
		
	}
}
