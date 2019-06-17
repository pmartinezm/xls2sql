package controller.reflexion;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import controller.comandos.ComandoFiltro;
import util.StringUtils;

/**
 * Busca los filtros mediante reflexión para ser cargados automáticamente.
 * 
 * @author Pablo
 *
 */
public class CargadorComandos {
	private String absolutePath;
	private String packagePath;

	/**
	 * Constructor.
	 * 
	 * @param packagePath
	 *            path del paquete separado por puntos (desde src)
	 */
	public CargadorComandos(String packagePath) {
		this.absolutePath = getProjectPath();
		this.packagePath = packagePath;
	}

	/**
	 * Obtiene la ruta de la raíz del proyecto.
	 * 
	 * @return
	 */
	private String getProjectPath() {
		File f = new File(".");
		String path = f.getAbsolutePath();

		return path.substring(0, path.length() - 2);
	}

	/**
	 * Busca los filtros, los instancia y los añade a una lista.
	 * 
	 * @return la lista de los filtros.
	 */
	public ArrayList<ComandoFiltro> getFilters() {
		File dir = new File(this.absolutePath + "/src/" + this.packagePath.replace(".", "/"));
		ArrayList<ComandoFiltro> comandos = new ArrayList<>();

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				String fileName = StringUtils.removeExtension(file.getName());

				try {
					Class<?> c = Class.forName(this.packagePath + "." + fileName);

					if (c.getModifiers() != 1025) { // Valor del modificador abstract
						ComandoFiltro ins = (ComandoFiltro) c.newInstance();
						comandos.add((ComandoFiltro) ins);
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					System.err.println("Error: " + file.getName());
				}
			}
		}
		return comandos;
	}
}
