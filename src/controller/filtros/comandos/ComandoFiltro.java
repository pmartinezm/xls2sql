package controller.filtros.comandos;

import controller.interfaces.IComandoFiltro;

/**
 * Elementos de la lista de filtros
 * 
 * @author pmartinezmar
 *
 */
public abstract class ComandoFiltro implements IComandoFiltro {
	protected String nombre;

	@Override
	public String toString() {
		return this.nombre;
	}
}
