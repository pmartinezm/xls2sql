import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GestorArchivo_new {
    private String path;
    private ArrayList<File> archivos = new ArrayList<>();
    private String[] extensiones = {"xls", "xlsx"};

    public GestorArchivo_new(String path) {
        this.path = path;
        this.generarArchivos();
    }

    public GestorArchivo_new() {
        this.path = "/home/pablo/Escritorio/Copia_de_Horario_de_clase_por_grupos.xls";
        this.generarArchivos();
    }

    public static void main(String[] args) {
        new GestorArchivo_new("/home/pablo/Escritorio/");
    }


    /**
     * Si el archivo existe lo asigna a la propiedad.
     */
    private void generarArchivos() {
        File file = new File(this.path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directorio");
                File[] archivos = file.listFiles();
                for (File archivo : archivos) {
                    if (!(archivo.isDirectory()) && this.filtrarExtension(archivo.getName())) {
                        this.archivos.add(archivo);
                    }
                }
            } else {
                System.out.println("Archivo.");
                this.archivos.add(file);
            }
        } else {
            System.err.println("Ruta no encontrada.");
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
     * Obtiene el libro del archivo xls.
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
}