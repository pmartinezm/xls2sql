package modelo.comando.filtros;

import modelo.Filtro;

public class ComandoContarCursos extends ComandoFiltro {
	
	public ComandoContarCursos(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void ejecutar(Filtro filtro) {
		filtro.contarCursos();
		int res = filtro.getCursosCounter();
		this.resultados = String.valueOf(res);
	}
}
