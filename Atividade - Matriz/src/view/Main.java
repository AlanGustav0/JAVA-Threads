package view;

import controller.ThreadMatriz;

public class Main {

	public static void main(String[] args) {

		int[][] matriz = new int[3][5];

		int linhas = 3;
		int colunas = 5;
		String mostraMatriz = " ";

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = (int) (Math.random() * 99) + 1;
			}
		}

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				if(matriz[i][j] < 10) {
					mostraMatriz += "0" + matriz[i][j] + " ";
				}else {
					mostraMatriz += matriz[i][j] + " ";
				}
				
			}
			mostraMatriz += " \n ";
		}
		
		System.out.println("*** Matriz ***");
		System.out.println(mostraMatriz);

		for (int linha = 0; linha < 3; linha++) {
			Thread thread = new ThreadMatriz(matriz[linha], linha);
			thread.start();
		}

	}

}
