package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class ThreadCorrida extends Thread {

	private Semaphore semaforo;
	private Semaphore semaforo2;
	private int escuderia;
	private int id;
	private static int posChegada;
	private double menorTempo = 3000;
	private int numCarro = 0;
	private static Classificacao[] vect;

	public ThreadCorrida(int escuderia, Semaphore semaforo, Semaphore semaforo2, int id) {
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;
		this.escuderia = escuderia;
		this.id = id;
		vect = new Classificacao[14];

	}

	public void run() {
		// ------------Início Seção Crítica 1------------
		if (getId() == getId()) {
			try {
				semaforo2.acquire();
				entradaPista();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaforo2.release();
			}

		}

		// ------------Fim da Seção Crítica 1------------
		
		
		// ------------Início Seção Crítica 2------------
		try {
			semaforo.acquire();
			pista();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		// ------------Fim da Seção Crítica 2------------

		chegada();

	}

	private void entradaPista() {

		System.out.println(
				"O carro " + getId() + " da escuderia  " + escuderia + " esta aguardando para entrar na pista");

	}

	private void pista() {

		int totalVoltas = 3;
		int voltasEfetuadas = 0;
		int tempoVoltas = (int) (Math.random() * 501) + 1500;
		int percurso = 0;

		System.out.println("O carro " + getId() + " da escuderia  " + escuderia + " entrou na pista");

		while (voltasEfetuadas < totalVoltas) {

			double tempoInicio = System.nanoTime();

			voltasEfetuadas++;

			try {
				sleep(tempoVoltas);
				System.out.println("O carro " + getId() + " da escuderia  " + escuderia + " completou a "
						+ voltasEfetuadas + "º volta");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			numCarro = (int) getId();

			double tempoFinal = System.nanoTime();
			double tempoTotal = (tempoFinal - tempoInicio);
			tempoTotal = tempoTotal / (int) Math.pow(10, 9);

			if (tempoTotal < menorTempo) {
				double auxiliar = tempoTotal;
				menorTempo = auxiliar;
			}

		}

		vect[id] = new Classificacao(numCarro, escuderia, menorTempo);

	}

	private void chegada() {

		posChegada++;
		String equipes = "";
		double auxTempo;
		int auxEscuderia;
		int auxId;

		if (posChegada != 14) {
			System.out.println("O carro " + vect[id].getId() + " da escuderia " + vect[id].getEscuderia()
					+ " finalizou a corrida Tempo: " + vect[id].getTempo() + "\n");
		} else {

			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 13; j++) {
					if (vect[j].getTempo() > vect[j + 1].getTempo()) {
						auxTempo = vect[j].getTempo();
						vect[j].setTempo(vect[j + 1].getTempo());
						vect[j + 1].setTempo(auxTempo);

						auxEscuderia = vect[j].getEscuderia();
						vect[j].setEscuderia(vect[j + 1].getEscuderia());
						vect[j + 1].setEscuderia(auxEscuderia);

						auxId = vect[j].getId();
						vect[j].setId(vect[j + 1].getId());
						vect[j + 1].setId(auxId);

					}
				}

			}

			for (int i = 0; i < 14; i++) {
				equipes += "Carro " + vect[i].getId() + " escuderia " + vect[i].getEscuderia() + " tempo: "
						+ vect[i].getTempo() + "\n";
			}
			System.out.println("");
			System.out.println("*********Classificação **********\n" + equipes);

		}

	}

}
