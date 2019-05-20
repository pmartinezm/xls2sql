package filtros.comandos;

import filtros.Filtros;

public class ComandoContarHorarios extends ComandoFiltro {
	public ComandoContarHorarios(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String ejecutar(Filtros filtro) {
		int res = filtro.contarHorarios();
		String out = "/* " + res + " horarios encontrados. */";
		
		return out;
	}

}
