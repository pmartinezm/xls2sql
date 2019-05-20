package modelo.horario;

import java.util.ArrayList;

public class Horario {
	private String curso;
    private ArrayList<Dia> dias = new ArrayList<>();

    public Horario(String curso) {
    	this.curso = curso;
    }

    public void addDia(Dia dia) {
        this.dias.add(dia);
    }
    
    public String getCurso() {
    	return this.curso;
    }
    
    public ArrayList<Dia> getDias() {
    	return this.dias;
    }
    
    public void mostrar() {
    	System.out.println("Curso: " + this.curso);
    	System.out.println("Días: " + this.dias.size());
    	System.out.println();
    	
    	for (Dia dia : dias) {
			System.out.println("Dia     ");
			
			ArrayList<Hora> horas = dia.getHoras();
			
			for (Hora hora : horas) {
				ArrayList<Asignatura> asignaturas = hora.getAsignaturas();
				
				for (Asignatura asignatura : asignaturas) {
					System.out.println(asignatura.toString());
				}
			}
		}
    	
    }
}
