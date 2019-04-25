package modelo.comando.filtros;

import modelo.Filtro;

public class ComandoContarHorarios extends ComandoFiltro {
	public ComandoContarHorarios(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void ejecutar(Filtro filtro) {
		filtro.contarHorarios();
		int res = filtro.getHorariosCounter();
		this.resultados = String.valueOf(res);
	}

}
