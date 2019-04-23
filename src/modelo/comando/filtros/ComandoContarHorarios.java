package modelo.comando.filtros;

import modelo.Filtro;

public class ComandoContarHorarios extends ComandoFiltro {
	private int resultados;

	public ComandoContarHorarios(String nombre, Filtro filtro) {
		super();
		this.nombre = nombre;
		this.filtro = filtro;
	}

	@Override
	public void ejecutar(Filtro filtro) {
		this.filtro.contarHorarios();
		this.resultados = this.filtro.getHorariosCounter();
	}

	public int getResultados() {
		return this.resultados;
	}

}
