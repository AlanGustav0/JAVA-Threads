package controller;

import java.util.concurrent.Semaphore;

public class ThreadServidor extends Thread {

	private Semaphore semaforo;
	private int id;

	public ThreadServidor(Semaphore semaforo, int id) {

		this.semaforo = semaforo;
		this.id = id;

	}

	public void run() {

		// ----------------Inicio da Seção Crítica--------------
		servidor();
		// -----------------Fim da Seção Crítica---------------
	}

	public void servidor() {

		int opc = id % 3;

		switch (opc) {

		case 1:
			try {
				semaforo.acquire();
				processamento_1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;

		case 2:
			try {
				semaforo.acquire();
				processamento_2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;
		case 0:

			try {
				semaforo.acquire();
				processamento_0();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;

		default:
			System.out.println("Processando....");
			break;

		}

	}

	private void processamento_1() {
		int tempoCalculos = (int) (Math.random() * 801) + 200;
		int tempoTransacao = 1000;

		for (int i = 0; i < 2; i++) {
			try {
				sleep(tempoCalculos);
				System.out.println("Id: " + id + " Calculando informações...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				sleep(tempoTransacao);
				System.out.println("Id: " + id + " Transacionando no Banco de dados...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void processamento_2() {
		int tempoCalculos = (int) (Math.random() * 1001) + 500;
		int tempoTransacao = 1500;

		for (int i = 0; i < 3; i++) {
			try {
				sleep(tempoCalculos);
				System.out.println("Id: " + id + " Calculando informações...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				sleep(tempoTransacao);
				System.out.println("Id: " + id + " Transacionando no Banco de dados...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void processamento_0() {
		int tempoCalculos = (int) (Math.random() * 1001) + 1000;
		int tempoTransacao = 1500;

		for (int i = 0; i < 3; i++) {
			try {
				sleep(tempoCalculos);
				System.out.println("Id: " + id + " Calculando informações...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				sleep(tempoTransacao);
				System.out.println("Id: " + id + " Transacionando no Banco de dados...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
