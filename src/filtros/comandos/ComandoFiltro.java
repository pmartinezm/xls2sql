package filtros.comandos;

import interfaces.IComandoFiltro;

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
