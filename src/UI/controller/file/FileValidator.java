package UI.controller.file;

import java.io.File;

import gestor.GestorArchivo;

public class FileValidator {

	public FileValidator() {
	}

	public boolean validate2(String path) {
		try {
			File file = new File(path);

			if (file.exists()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean validate(String path) {
		GestorArchivo g = new GestorArchivo(path);
		return g.estado();
	}
}
