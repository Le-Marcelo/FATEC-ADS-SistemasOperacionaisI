package controller;

import java.util.concurrent.Semaphore;

public class BancoController extends Thread{

	private static Semaphore semaforo = new Semaphore(1);
	int threadId;
	
	public BancoController(int _threadId) {
		threadId = _threadId;
	}

	@Override
	public void run() {
		
		if(threadId % 3 == 1) {
			for(int i = 0; i < 2; i++) {
				calc(0.2 , 1d);
				transacao(1d);
			}
			
		}else if(threadId % 3 == 2) {
			for(int i = 0; i < 3; i++) {
				calc(0.5 , 1.5);
				transacao(1.5);
			}
			
		}else {
			for(int i = 0; i < 3; i++) {
				calc(1d , 2d);
				transacao(1.5);
			}
			
		}
	}
	
	public void calc(Double calcMin, Double calcMax) {
		
		calcMax -= calcMin;
		
		try {
			System.out.println("Calculo da thread " + threadId);
			sleep((long) (Math.random() * calcMax + calcMin));
			
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
			
		}
	}
	
	public void transacao(Double tempo) {
		
		try {
			semaforo.acquire();
			System.out.println("Começo da transação da thread " + threadId);
			sleep((long) (tempo * 1000));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			System.out.println("Fim da transação da thread " + threadId);
			semaforo.release();
			
		}
	}
	
}
