package modelo;

import java.util.ArrayList;

public class Hora {
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();

    public Hora() {
    }
    
    public Hora(ArrayList<Asignatura> asignaturas) {
    	this.asignaturas = asignaturas;
    }
    
    public void addAsignatura(Asignatura asignatura) {
    	this.asignaturas.add(asignatura);
    }
    
    public ArrayList<Asignatura> getAsignaturas() {
    	return this.asignaturas;
    }
}
