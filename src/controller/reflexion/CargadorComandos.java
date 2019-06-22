package controller.reflexion;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import org.apache.log4j.lf5.util.Resource;

import controller.interfaces.IComandoFiltro;
import util.Debug;
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
	private Debug d;

	/**
	 * Constructor.
	 * 
	 * @param packagePath
	 *            path del paquete separado por puntos (desde src)
	 */
	public CargadorComandos(String packagePath) {
		this.d = Debug.getDebug();
		this.d.enable();
		this.d.title("Cargador comandos");
		this.absolutePath = getProjectPath();
		this.packagePath = packagePath;
	}

	/**
	 * Obtiene la ruta de la raíz del proyecto.
	 * 
	 * @return
	 */
	private String getProjectPath() {
		this.d.title("getObjectPath");
		File f = new File(".");
		String path = f.getAbsolutePath();

		this.d.entry("Path: " + path);
		this.d.entry("Corrected path: " + path.substring(0, path.length() - 2));
		this.d.title("");

		return path.substring(0, path.length() - 2);
	}

	/**
	 * Busca los filtros, los instancia y los añade a una lista.
	 * 
	 * @return la lista de los filtros.
	 */
	public ArrayList<IComandoFiltro> getFilters() {
		File dir = new File(this.absolutePath + "/src/" + this.packagePath.replace(".", "/"));
		ArrayList<IComandoFiltro> comandos = new ArrayList<>();

		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				String fileName = StringUtils.removeExtension(file.getName());

				try {
					Class<?> c = Class.forName(this.packagePath + "." + fileName);

					this.d.entry("Class: " + c.getName());

					if (c.getModifiers() != 1025) { // Valor del modificador abstract
						IComandoFiltro ins = (IComandoFiltro) c.newInstance();
						comandos.add((IComandoFiltro) ins);
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					System.err.println("Error: " + file.getName());
				}
			}
		}
		this.d.title("");
		return comandos;
	}
}
