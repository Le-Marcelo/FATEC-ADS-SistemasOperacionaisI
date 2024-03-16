package controller;


public class ContagemVetor {

	public ContagemVetor() {
		super();
	}
	
	public void TempoVetor(int[] vetor) {
		int tamanho = vetor.length;
		
		for(int i = 0; i < tamanho; i++) {			//Preenche o vetor
			vetor[i] = 0;
		}
		
		double tempoInicial = System.nanoTime();	//Começa a contagem do tempo
		for(int i = 0; i < tamanho; i++) {
			
		}
		double tempoFinal = System.nanoTime();		//Termina a contagem do tempo
		
		double tempoTotal = tempoFinal - tempoInicial;
		
		System.out.println(tempoTotal + " nS");
	}

}
