package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {

	private int numVertices;
	private List<Persona> vertices;
	private List<Set<Arista>> aristas;

	public Grafo(List<Persona> personas) {
		this.numVertices = personas.size();

		// Agrega los vértices Persona y crea todas las aristas para que el grafo sea
		// completo
		vertices = new ArrayList<>(numVertices);
		aristas = new ArrayList<>(numVertices);
		for (Persona origen : personas) {
			vertices.add(origen);
			HashSet<Arista> aristas = new HashSet<Arista>();
			for (Persona destino : personas) {
				if (!origen.equals(destino))
					aristas.add(new Arista(origen, destino));
			}
			this.aristas.add(aristas);
		}
	}

	public void agregarVertice(Persona persona) {
		vertices.add(persona);
		HashSet<Arista> vertice = new HashSet<Arista>();
		for (Persona vecino : vertices)
			if (!persona.equals(vecino))
				vertice.add(new Arista(persona, vecino));
		aristas.add(vertice);
	}

	// Función para imprimir la representación de la lista de adyacencia del grafo
	public void imprimirGrafo() {
		int origen = 0;
		int n = aristas.size();

		while (origen < n) {
			// imprime el vértice actual y todos sus vértices vecinos
			Set<Arista> target = aristas.get(origen);
			for (Arista vecino : target) {
				System.out.print(" (" + vecino.getOrigen().getNombre() +
						" ——> " + vecino.getDestino().getNombre()
						+ " | peso: " + vecino.getPeso() + ") ");
			}

			System.out.println();
			origen++;
		}
	}

	public int getNumVertices() {
		return numVertices;
	}

}