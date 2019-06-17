package controller.comandos;

import controller.filtros.Filtros;

public class ComandoPruebaReflex extends ComandoFiltro{
	
	public ComandoPruebaReflex() {
		super();
		this.nombre = "Comando de prueba apra la reflexión";
	}

	@Override
	public String ejecutar(Filtros filtro) {
		System.out.println("Funciona bien");
		return "Funciona bien";
	}
	
}
