package modelo;

import java.util.ArrayList;

public class Dia {
    private ArrayList<Hora> horas;

    public Dia() {
        this.horas = new ArrayList<Hora>();
    }

    public void addHora(Hora hora) {
        this.horas.add(hora);
    }
}
