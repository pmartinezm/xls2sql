package test;

import modelo.horarios.Asignatura;
import modelo.horarios.Dia;
import modelo.horarios.Hora;
import modelo.horarios.Horario;

public class HorarioModelTest {
	public static void main(String[] args) {
		Asignatura q = new Asignatura("q");
		Asignatura w = new Asignatura("w");
		Asignatura e = new Asignatura("e");
		Asignatura r = new Asignatura("r");
		Asignatura t = new Asignatura("t");
		Asignatura y = new Asignatura("y");
		
		Hora a = new Hora();
		Hora s = new Hora();
		Hora d = new Hora();
		Hora f = new Hora();
		Hora g = new Hora();
		Hora h = new Hora();
		
		a.addAsignatura(q);
		s.addAsignatura(w);
		d.addAsignatura(e);
		f.addAsignatura(r);
		g.addAsignatura(t);
		h.addAsignatura(y);
		
		Dia dia = new Dia();
		dia.addHora(a);
		dia.addHora(s);
		dia.addHora(d);
		dia.addHora(f);
		dia.addHora(g);
		dia.addHora(h);
		
		Horario horario = new Horario("Test");
		horario.addDia(dia);
		
		horario.mostrar();
		
	}
}
