package controller.comandos;

import controller.interfaces.IFiltros;

public class ComandoPruebaReflex extends ComandoFiltro{
	
	public ComandoPruebaReflex() {
		super();
		this.nombre = "Comando de prueba apra la reflexión";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		System.out.println("Funciona bien");
		return "Funciona bien";
	}
	
}
