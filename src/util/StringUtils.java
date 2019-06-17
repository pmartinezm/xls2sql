package util;

public class StringUtils {
	/**
	 * Elimnina la extensi�n de el nombre de archivo.
	 * @param fileName el nombre de archivo.
	 * @return el nombre de archivo sin extensi�n.
	 */
	public static String removeExtension(String fileName) {
		int dot = fileName.lastIndexOf(".");
		return fileName.substring(0, dot);
	}
}
