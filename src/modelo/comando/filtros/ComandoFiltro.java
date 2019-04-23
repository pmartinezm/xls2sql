package modelo.comando.filtros;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import modelo.Filtro;

/**
 * Elementos de la lista de filtros
 * 
 * @author pmartinezmar
 *
 */
public abstract class ComandoFiltro implements interfaces.IComandoFiltro {
	protected String nombre;
	protected Filtro filtro;
}
