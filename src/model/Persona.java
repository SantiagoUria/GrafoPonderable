package model;

public class Persona {
	
	private String nombre;
	private int deportes, musica, espectaculo, ciencia;

	Persona(String nombre, int deportes, int musica, int espectaculo, int ciencia) {
		this.nombre = nombre;
		this.deportes = deportes;
		this.musica = musica;
		this.espectaculo = espectaculo;
		this.ciencia = ciencia;
	}

	public int similaridad(Persona p) {
		return Math.abs(this.deportes - p.deportes)
				+ Math.abs(this.musica - p.musica)
				+ Math.abs(this.espectaculo - p.espectaculo)
				+ Math.abs(this.ciencia - p.ciencia);
	}

	public String getNombre() {
		return nombre;
	}

	public boolean equals(Persona persona) {
		return nombre.equals(persona.nombre) &&
				deportes == persona.deportes &&
				musica == persona.musica &&
				espectaculo == persona.espectaculo &&
				ciencia == persona.ciencia;
	}
}
