package model;

public class Persona {
	private String nombre;
	private int deportes, musica, espectaculo, ciencia; // deportes, música, espectáculo, ciencia

	Persona(String nombre, int di, int mi, int ei, int ci) {
		this.nombre = nombre;
		this.deportes = di;
		this.musica = mi;
		this.espectaculo = ei;
		this.ciencia = ci;
	}

	public int similaridad(Persona p) {
		return Math.abs(this.deportes - p.deportes) + Math.abs(this.musica - p.musica)
				+ Math.abs(this.espectaculo - p.espectaculo) + Math.abs(this.ciencia - p.ciencia);
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
