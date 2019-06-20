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
}
