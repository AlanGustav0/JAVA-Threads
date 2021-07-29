package view;

import java.util.concurrent.Semaphore;

import controller.ThreadServidor;

public class Processamento {

	public static void main(String[] args) {

		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);

		for (int idThread = 1; idThread < 22; idThread++) {

			Thread tProcesso = new ThreadServidor(semaforo,idThread);
			tProcesso.start();
		}

	}

}
