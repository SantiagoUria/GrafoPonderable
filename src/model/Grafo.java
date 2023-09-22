package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Grafo {

	private int cantVertices;
	private List<Persona> vertices;
	private List<Set<Arista>> listaDeVecinos;

	public Grafo(List<Persona> personas) {
		this.cantVertices = personas.size();

		// Agrega los vértices Persona y crea todas las aristas para que el grafo sea
		// completo
		vertices = new ArrayList<>(cantVertices);
		listaDeVecinos = new ArrayList<>(cantVertices);
		for (Persona persona : personas) {
			vertices.add(persona);
			HashSet<Arista> vecinos = new HashSet<Arista>();
			for (Persona vecino : personas)
				if (!persona.equals(vecino))
					vecinos.add(new Arista(persona, vecino));
			listaDeVecinos.add(vecinos);
		}
	}

	public void agregarVertice(Persona persona) {
		vertices.add(persona);
		HashSet<Arista> vertice = new HashSet<Arista>();
		for (Persona vecino : vertices)
			if (!persona.equals(vecino))
				vertice.add(new Arista(persona, vecino));
		listaDeVecinos.add(vertice);
	}

	public ArbolGeneradorMinimo generarArbolMinimo() {
		ArbolGeneradorMinimo agm = new ArbolGeneradorMinimo();
		Set<Integer> vVisitados = new HashSet<Integer>();

		vVisitados.add(0);

		while (vVisitados.size() < cantVertices) {
			int pesoMinimo = Integer.MAX_VALUE;
			Arista aristaMinima = null;

			for (int vActual : vVisitados) {
                Set<Arista> vecinos = listaDeVecinos.get(vActual);
				for (Arista arista : vecinos) {
					if (!vVisitados.contains(vertices.indexOf(arista.getDestino())) && arista.getPeso() < pesoMinimo) {
                        pesoMinimo = arista.getPeso();
                        aristaMinima = arista;
                    }

				}
			}
            if (aristaMinima != null) {
                agm.add(aristaMinima);
                vVisitados.add(vertices.indexOf(aristaMinima.getDestino()));
            }
		}
		return agm;
	}

	// Función para imprimir la representación de la lista de adyacencia del grafo
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int indice = 0;
		while (indice < cantVertices) {
			sb.append("#").append(indice).append(" ");
			sb.append(vertices.get(indice).getNombre()).append("   ");
			// imprime el vértice actual y todos sus vértices vecinos
			for (Arista vecino : listaDeVecinos.get(indice)) {
				sb.append("(").append(vecino.getDestino().getNombre());
				sb.append(", ").append(vecino.getPeso()).append("), ");
			}
			sb.deleteCharAt(sb.length() - 2);
			sb.append("\n");
			indice++;
		}
		return sb.toString();
	}

	public int getNumVertices() {
		return cantVertices;
	}

}