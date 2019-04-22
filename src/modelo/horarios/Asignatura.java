package modelo.horarios;

public class Asignatura {
	private String nombre;
	
	public Asignatura(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
