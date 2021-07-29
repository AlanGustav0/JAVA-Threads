package controller;

public class Classificacao {

	private int id;
	private int escuderia;
	private double tempo;

	public Classificacao(int id, int escuderia, double tempo) {
		this.id = id;
		this.escuderia = escuderia;
		this.tempo = tempo;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(int escuderia) {
		this.escuderia = escuderia;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	
}
