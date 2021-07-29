package view;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import controller.ThreadCorrida;

public class Equipes {

	public static void main(String[] args) {

		int acessoCorrida = 5;
		Semaphore semaforo = new Semaphore(acessoCorrida);

		int esperaEntrada = 1;
		Semaphore semaforo2 = new Semaphore(esperaEntrada);

		int escuderia = 0;
		int i;
		int id = 0;

		for (i = 0; i < 14; i++) {
			escuderia++;
			Thread tCarro = new ThreadCorrida(escuderia, semaforo, semaforo2, i);
			tCarro.start();

			if (escuderia == 7) {
				escuderia = 0;
			}
		}

	}

}
