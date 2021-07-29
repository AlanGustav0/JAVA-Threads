package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {

	private int idPessoa;
	private static int posChegada;
	private static int posEntrada;
	private Semaphore semaforo;

	public ThreadCorredor(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		pessoaAndando();
		
		//-------------------Inicio Seção crítica-------------------
		try {
			semaforo.acquire();
			abrePorta();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		//-------------------Fim Seção crítica-------------------
		pessoaEntrou();
	}

	private void pessoaAndando() {
		int tamanhoCorredor = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) (Math.random() * 3) + 4;
		int tempoDeslocamento = 1000;

		while (distanciaPercorrida < tamanhoCorredor) {

			distanciaPercorrida += deslocamento;

			try {
				sleep(tempoDeslocamento);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("A pessoa: " + idPessoa + " já andou " + distanciaPercorrida + "m");

		}
		posChegada++;
		
		System.out.println("A pessoa: " + idPessoa + " foi a " + posChegada + "º a chegar");

	}

	private void abrePorta() {
		int abrirPorta = (int) (Math.random() * 1001) + 1000;

		System.out.println("A pessoa: " + idPessoa + " está abrindo a porta");
		try {
			sleep(abrirPorta);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void pessoaEntrou() {
		posEntrada++;
		System.out.println("A pessoa: " + idPessoa + " foi a " + posChegada + "º a entrar");
	}

}
