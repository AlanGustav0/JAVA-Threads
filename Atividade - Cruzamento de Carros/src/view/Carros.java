package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Carros {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idCarros = 0; idCarros < 4; idCarros++) {
			Thread tCarros = new ThreadCruzamento(idCarros, semaforo);
			tCarros.start();
		}

	}

}
