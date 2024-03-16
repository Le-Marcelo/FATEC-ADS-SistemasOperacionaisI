package controller;

import java.util.concurrent.Semaphore;

public class CorredorController extends Thread{
	
	private static Semaphore semaforo = new Semaphore(1);
	int idPessoa, distancia, velocidadeMinima, velocidadeMaxima;

	public CorredorController(int _idPessoa, int _distancia, int _velocidadeMinima, int _velocidadeMaxima) {
		idPessoa = _idPessoa;
		distancia =  _distancia;
		velocidadeMinima = _velocidadeMinima;
		velocidadeMaxima = _velocidadeMaxima;
	}
	
	@Override
	public void run() {
		andar();
	}
	
	public void andar() {
		int posicao = 0;
		
		try {
			while(posicao < distancia) {
				posicao += (int) Math.random() * (velocidadeMaxima - velocidadeMinima) + velocidadeMinima;
				System.out.println("Pessoa " + idPessoa + " andou " + posicao + "m.");
				sleep(1000);
			}
			
			semaforo.acquire();
			atravessar();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		} finally {
			semaforo.release();
			
		}
	}
	
	public void atravessar() {
		try {
			sleep((long) Math.random() * 1000 + 1000);
			System.out.println("Pessoa " + idPessoa + " atravessou a porta.");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
			
	}
	
}
