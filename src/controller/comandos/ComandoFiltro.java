package controller.comandos;

import controller.interfaces.IComandoFiltro;
import util.Debug;

/**
 * Elementos de la lista de filtros
 * 
 * @author pmartinezmar
 *
 */
public abstract class ComandoFiltro implements IComandoFiltro {
	protected String nombre;
	protected Debug d = Debug.getDebug();

	@Override
	public String toString() {
		return this.nombre;
	}
}
