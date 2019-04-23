package modelo.comando.filtros;

import modelo.Filtro;

public class ComandoContarCursos extends ComandoFiltro {
	private int resultados;
	
	public ComandoContarCursos(String nombre, String metodo, Filtro filtro) {
		super();
		this.nombre = nombre;
		this.filtro = filtro;
	}

	@Override
	public void ejecutar(Filtro filtro) {
		this.filtro.contarCursos();
		this.resultados = this.filtro.getCursosCounter();
	}
	
	public int getResultados() {
		return this.resultados;
	}
}
