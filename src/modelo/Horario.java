package modelo;

import java.util.ArrayList;

public class Horario {
    private ArrayList<Dia> dias;

    public Horario() {
        this.dias = new ArrayList<Dia>();
    }

    public void addDia(Dia dia) {
        this.dias.add(dia);
    }
}
