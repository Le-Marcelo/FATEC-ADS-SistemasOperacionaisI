package controller;

import java.util.concurrent.Semaphore;

public class JogoController extends Thread{
	
	private static Semaphore semaforoEntrega = new Semaphore(1);
	private static Semaphore semaforoSopa = new Semaphore(1);
	private static Semaphore semaforoLasanha = new Semaphore(1);
	int idPrato;
	
	public JogoController(int _idPrato) {
		idPrato = _idPrato;
	}

	@Override
	public void run() {
		String nome;
		if(idPrato % 2 != 0) {
			nome = "Sopa de Cebola";
			cozinhar(0.5, 0.8, nome, semaforoSopa);
			
		}else {
			nome = "Lasanha a Bolonhesa";
			cozinhar(0.6, 1.2, "Lasanha a Bolonhesa", semaforoLasanha);
			
		}
		
		entregar(nome);
	}
	
	public void cozinhar(Double tempoMin, Double tempoMax, String nome, Semaphore semaforo) {
		
		Double tempoDeCozimento = Math.random() * 0.3 + 0.5;
		
		try {
			semaforo.acquire();
			
			for(Double i = 0d; i < tempoDeCozimento; i += 0.1) {
				sleep(100);
				Double percentual = i * 100 / tempoDeCozimento;
				System.out.println(String.format("%s - %.0f%s", nome, percentual, "%"));
			}
			
			System.out.println(nome + " - Concluída!");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			semaforo.release();
			
		}
	}
	
	public void entregar(String nome) {
		try {
			semaforoEntrega.acquire();
			sleep(500);
			System.out.println(nome + " - Entregue!");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			semaforoEntrega.release();
		}
		
	}
	
}
