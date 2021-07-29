package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {

	private int idCarros;
	private Semaphore semaforo;
	private static int posCruzamento;
	private static int posTravessia;

	public ThreadCruzamento(int idCarros, Semaphore semaforo) {
		this.idCarros = idCarros;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		carroAndando();

		// -----------------Inicio da Seção crítica---------------------
		try {
			semaforo.acquire();
			cruzamento();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

		// -----------------Fim da Seção crítica---------------------
		carroPassou();
	}

	private void carroAndando() {
		int distanciaTotal = 1000;
		int distanciaPercorrida = 0;
		int deslocamento = (int) (Math.random() * 100) + 1;
		int tempo = 1000;

		while (distanciaPercorrida < distanciaTotal) {

			distanciaPercorrida += deslocamento;

			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("O carro " + idCarros + " já andou " + distanciaPercorrida + "m");
		}
		posCruzamento++;

		System.out.println("* O carro " + idCarros + " foi o " + posCruzamento + "º a chegar no cruzamnto.");
		
		

	}

	private void cruzamento() {
		int tempoCruzamento = 2000;
		if(idCarros == 0) {
			System.out.println("* O carro " + idCarros + " está atravessando o cruzamento sentido Leste");
		}else if(idCarros == 1) {
			System.out.println("* O carro " + idCarros + " está atravessando o cruzamento sentido Sul");
		}else if(idCarros == 2) {
			System.out.println("* O carro " + idCarros + " está atravessando o cruzamento sentido Oeste");
		}else {
			System.out.println("* O carro " + idCarros + " está atravessando o cruzamento sentido Norte");
		}
		
		try {
			sleep(tempoCruzamento);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void carroPassou() {
		posTravessia++;

		System.out.println("* O carro " + idCarros + " foi o " + posTravessia + "º a atravessar o cruzameto.");

	}

}
