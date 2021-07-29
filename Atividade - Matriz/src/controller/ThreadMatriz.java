package controller;

public class ThreadMatriz extends Thread {

	private int vetor[];
	private int linha;

	public ThreadMatriz(int[] vetor, int linha) {
		this.vetor = vetor;
		this.linha = linha;
	}

	@Override
	public void run() {
		somaMatriz();
	}

	public void somaMatriz() {
		int somaLinha = 0;

		if (linha == 0) {
			for (int i = 0; i < 5; i++) {
				somaLinha += vetor[i];
			}

		} else if (linha == 1) {

			for (int i = 0; i < 5; i++) {
				somaLinha += vetor[i];
			}
		} else {
			for (int i = 0; i < 5; i++) {
				somaLinha += vetor[i];

			}
		}

		System.out.println("Soma da linha " + (linha + 1) + " - " + somaLinha + "\n");

	}

}
