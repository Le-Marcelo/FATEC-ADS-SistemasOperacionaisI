package controller;

import java.util.concurrent.Semaphore;

import br.edu.fateczl.ordenacao.quicksort.QuickSort;

public class Formula1Controller extends Thread{
	
	private static Semaphore semaforoEscuderia[] = new Semaphore[7];	//Um carro de cada escuderia
	private static Semaphore semaforoCarros = new Semaphore(5);		//5 carros por vez
	
	private static double[] tempos = new double[14];
	
	int idCarro, idEscuderia;
	
	public Formula1Controller(int _idCarro, int _idEscuderia) {
		idCarro = _idCarro;
		idEscuderia = _idEscuderia;
	}
	
	@Override
	public void run() {
		liberarCarro();
		correr();
		receberCarro();
		
		if(semaforoCarros.availablePermits() == 5) {
			exibirGrid();
		}
	}
	
	public void correr() {
		double melhorTempo = 0;
		double tempoVolta; 
		
		for (int i = 0; i < 3; i++) {	//Número de voltas = 3
			
			try {
				long tempoInicial = System.nanoTime();
				sleep((long) (Math.random() * 1200 + 600));	//Trajeto de 1 a 3 minutos (* 120000 + 60000)
				long tempoFinal = System.nanoTime();
				tempoVolta = (tempoFinal - tempoInicial) / 1e+9;	//Nano -> Segundo
				
				if(i == 0) {
					melhorTempo = tempoVolta;
					
				}else if(tempoVolta < melhorTempo) {
					melhorTempo = tempoVolta;
					
				}
				
				System.out.println(String.format("Carro %d - %dª volta: %.0fmin%.0fs", idCarro, (i + 1), (tempoVolta / 60), (tempoVolta % 60)));
				
			}catch(Exception e){
				System.err.println(e.getMessage());
				
			}
		}
		
		tempos[idCarro] = melhorTempo;
	}
	
	public void liberarCarro() {
		try {
			semaforoEscuderia[idEscuderia] = new Semaphore(1);
			semaforoEscuderia[idEscuderia].acquire();
			semaforoCarros.acquire();
			
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
			
		}
		
	}
	
	public void receberCarro() {
		try {
			semaforoEscuderia[idEscuderia].release();
			semaforoCarros.release();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}
	}

	public void exibirGrid() { //TODO Associar tempo com cada carro (OO?)
		try {
			QuickSort sort = new QuickSort();
				
			double grid[] = tempos;
			int colocacao = 0;
				
			grid = sort.quickSort(grid, 0, tempos.length - 1);
				
			for(double i : grid) {
				colocacao++;
				int carro = 0;
				for(int j = 0; j < tempos.length; j++) {
					if(i == tempos[j]) {
						carro = j;
						break;
					}
				}
				
				System.out.println("Grid de largada");
				System.out.println(String.format("%dº Carro %d - %.0fmin%.0fs", colocacao, carro, (i / 60), (i % 60)));
					
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
			
		}
		
	}
	
}
