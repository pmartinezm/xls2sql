package controller.comandos;

import controller.interfaces.IFiltros;

public class ComandoPruebaReflex extends ComandoFiltro {

	public ComandoPruebaReflex() {
		super();
		this.nombre = "Comando de prueba apra la reflexión";
	}

	@Override
	public String ejecutar(IFiltros filtro) {
		d.write("Ejecutando comando " + getClass().getSimpleName() + ".");
		return "Funciona bien";
	}

}
