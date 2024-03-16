package controller;

import java.util.concurrent.Semaphore;

public class BancoController extends Thread{

	private static Semaphore semaforoSaque = new Semaphore(1), semaforoDeposito = new Semaphore(1);
	int idConta, saldo, valor, tipo;

	@Override
	public void run() {
		try {
			if(tipo <= 5 ) {
				saque();

			}else {
				deposito();

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public BancoController(int _idConta, int _saldo, int _valor, int _tipo) {
		idConta = _idConta;
		saldo = _saldo;
		valor = _valor;
		tipo = _tipo;
	}

	public void saque() throws Exception{
		if(saldo < valor) {
			throw new Exception ("Saldo indisponível para saque");
			
		}else {
			try {
				semaforoSaque.acquire();
				saldo -= valor;
				System.out.println("Conta " + idConta + " - Foram sacados R$" + valor + " - Valor restante: R$" + saldo);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				
			} finally {
				semaforoSaque.release();
				
			}
		}

	}

	public void deposito() {
		try {
			semaforoDeposito.acquire();
			saldo += valor;
			System.out.println("Conta " + idConta + " - Foram depositados R$" + valor + " - Valor atual: R$" + saldo);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			semaforoDeposito.release();
			
		}
	}

}
