import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivo {
    private String path;
    private File file;
    private String[] extensions = {"xls", "xlsx"};

    public GestorArchivo(String path) {
            this.path = path;
            this.generarArchivo();
    }

    public GestorArchivo() {
        this.path = "/home/pablo/Escritorio/Copia_de_Horario_de_clase_por_grupos.xls";
        this.generarArchivo();
    }


    /**
     * Si el archivo existe lo asigna a la propiedad.
     */
    private void generarArchivo() {
        File file = new File(this.path);

        if (file.exists()) {
            if(file.isDirectory()){
                System.out.println("Path es directorio.");
                File directorio = new File(this.path);
                File[] archivos = directorio.listFiles();
            } else {
                System.out.println("Path es archivo.");
                this.file = file;
                System.out.println("Archivo generado.");
            }
        } else {
            this.file = null;
            System.err.println("El archivo no existe.");
        }
    }

    /**
     * Obtiene el libro del archivo xls.
     * @return el libro de trabajo.
     * @throws IOException
     */
    public XSSFWorkbook getLibro() throws IOException {
        FileInputStream fis = new FileInputStream(this.file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        fis.close();
        return wb;
    }
}