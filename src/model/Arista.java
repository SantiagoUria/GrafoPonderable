package model;

public class Arista {
	private Persona origen, destino;
	private int peso;

	Arista(Persona origen, Persona destino) {
		this.origen = origen;
		this.destino = destino;
		peso = origen.similaridad(destino);
	}

	public Persona getOrigen() {
		return origen;
	}

	public Persona getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}
}
