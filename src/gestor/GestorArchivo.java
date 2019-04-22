package gestor;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.Debug;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GestorArchivo {
	private String path;
	private ArrayList<File> archivos = new ArrayList<>();
	private String[] extensiones = { "xls", "xlsx" };
	private Debug debug = Debug.getDebug();

	public GestorArchivo(String path) {
		this.path = path;
		this.generarArchivos();
		this.debug.write("Archivos: " + this.archivos.size());
	}

	public GestorArchivo() {
		this.path = "/home/pablo/Escritorio/Todos los horarios.xlsx";
		this.generarArchivos();
		this.debug.write("Archivos: " + this.archivos.size());
	}

	/**
	 * Si el archivo existe lo asigna a la propiedad.
	 */
	private void generarArchivos() {
		File file = new File(this.path);

		if (file.exists()) {
			if (file.isDirectory()) {
				this.debug.write("Directorio reconocido.");
				File[] archivos = file.listFiles();
				for (File archivo : archivos) {
					if (!(archivo.isDirectory()) && this.filtrarExtension(archivo.getName())) {
						this.archivos.add(archivo);
						this.debug.write("Nombre del archivo: " + archivo.getName());
					}
				}
			} else {
				this.debug.write("Archivo reconocido.");
				this.archivos.add(file);
			}
		} else {
			this.debug.error("Ruta no encontrada.");
		}
	}

	private String extraerExtension(String nombreArchivo) {
		int punto = nombreArchivo.lastIndexOf(".");
		return nombreArchivo.substring(punto + 1);
	}

	private boolean filtrarExtension(String nombreArchivo) {
		if (!nombreArchivo.contains(".")) {
			return false;
		}
		for (String extension : this.extensiones) {
			if (this.extraerExtension(nombreArchivo).equalsIgnoreCase(extension)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtiene los libros del archivo xls.
	 *
	 * @return el libro de trabajo.
	 * @throws IOException
	 */
	public ArrayList<XSSFWorkbook> getLibros() throws IOException {
		ArrayList<XSSFWorkbook> libros = new ArrayList<>();
		FileInputStream fis = null;
		for (File archivo : this.archivos) {
			fis = new FileInputStream(archivo);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			libros.add(wb);
		}
		fis.close();
		return libros;
	}

	public boolean isValido() {
		return this.archivos.size() > 0;
	}
}