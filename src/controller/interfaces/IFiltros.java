package controller.interfaces;

import java.util.ArrayList;

import modelo.horario.Horario;

public interface IFiltros {
	public int contarHorarios();
	public int contarCursos();
	public ArrayList<String> extraerCursos();
	public ArrayList<Horario> extraerHorarios();
	public Object creandoUnFiltro();
}
