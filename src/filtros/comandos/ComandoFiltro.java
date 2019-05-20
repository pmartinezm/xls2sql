package filtros.comandos;

/**
 * Elementos de la lista de filtros
 * 
 * @author pmartinezmar
 *
 */
public abstract class ComandoFiltro implements interfaces.IComandoFiltro {
	protected String nombre;
	protected String resultados;

	public String getResultados() {
		return this.resultados;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}
