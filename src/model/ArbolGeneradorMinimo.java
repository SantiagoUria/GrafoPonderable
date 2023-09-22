package model;

import java.util.HashSet;
import java.util.Set;

public class ArbolGeneradorMinimo {
	Set<Arista> aristas;
	int peso;

	public ArbolGeneradorMinimo() {
		aristas = new HashSet<Arista>();
	}

	public void add(Arista arista) {
		aristas.add(arista);
	}

	public Arista aristaMasPesada() {
		Arista pesada = null;
		for (Arista arista : aristas) {
			if (pesada == null || arista.getPeso() > pesada.getPeso()) {
				pesada = arista;
			}
		}
		return pesada;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int peso = 0;
		for (Arista a : aristas) {
			sb.append(a.toString());
			peso += a.getPeso();
		}
		sb.append("Peso total: ").append(peso).append("\n");
		return sb.toString();
	}
}
