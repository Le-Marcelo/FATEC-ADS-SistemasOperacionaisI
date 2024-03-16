package controller;

import java.util.concurrent.Semaphore;

public class SemaforoController extends Thread{
	
	private static Semaphore semaforo = new Semaphore(1); 
	int idCarro;
	
	public SemaforoController(int _idCarro) {
		idCarro = _idCarro;
	}
	
	@Override
	public void run() {
		Atravessar();
	}
	
	public void Atravessar() {
		
		try {
			
			semaforo.acquire(1);
			
			switch(idCarro + 1) {
				case 1:
					System.out.println("Carro " + idCarro + " atravessando o cruzamento do oeste ao leste.");
					break;
				
				case 2:
					System.out.println("Carro " + idCarro + " atravessando o cruzamento do sul ao norte.");
					break;
					
				case 3:
					System.out.println("Carro " + idCarro + " atravessando o cruzamento do leste ao oeste.");
					break;
					
				case 4:
					System.out.println("Carro " + idCarro + " atravessando o cruzamento do norte ao sul.");
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			semaforo.release();
		}
	}
	
	
	
}
