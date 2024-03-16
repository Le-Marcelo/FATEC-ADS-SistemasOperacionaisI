package view;

import controller.ContagemVetor;

public class Principal {

	public static void main(String[] args) {
		int[] vetor1 = new int[1000], vetor2 = new int[10000], vetor3 = new int[10000];
		
		ContagemVetor tv = new ContagemVetor();
		
		tv.TempoVetor(vetor1);
		tv.TempoVetor(vetor2);
		tv.TempoVetor(vetor3);
	}

}
