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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(origen.getNombre()).append(" - ");
		sb.append(destino.getNombre());
		sb.append(" ").append(peso).append("\n");
		return sb.toString();
	}
}
