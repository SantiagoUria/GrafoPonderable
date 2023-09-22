package model;

import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		// construye lista de personas a conectar con el grafo
		ArrayList<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Santi", 1, 2, 3, 4));
		personas.add(new Persona("Chimi", 1, 2, 4, 4));
		personas.add(new Persona("Michael", 2, 3, 4, 3));
		personas.add(new Persona("Gorda", 1, 2, 2, 3));
		personas.add(new Persona("Ruby", 1, 3, 3, 1));
		personas.add(new Persona("Agus", 1, 2, 3, 4));

		// construye el grafo a partir de la lista de personas dada
		Grafo grafo = new Grafo(personas);

		// imprime la representación de la lista de vecinos del grafo
		System.out.println(grafo.toString());

		ArbolGeneradorMinimo agm = grafo.generarArbolMinimo();

		System.out.println(agm.toString());

		agm.eliminarAristaMasPesada();

		System.out.println(agm.toString());		

	}
}
