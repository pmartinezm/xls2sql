package util;

public class StringUtils {
	/**
	 * Elimnina la extensión de el nombre de archivo.
	 * @param fileName el nombre de archivo.
	 * @return el nombre de archivo sin extensión.
	 */
	public static String removeExtension(String fileName) {
		int dot = fileName.lastIndexOf(".");
		return fileName.substring(0, dot);
	}
}
