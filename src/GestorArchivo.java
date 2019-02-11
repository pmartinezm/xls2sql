import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GestorArchivo {
    private String path;
    private File file;

    public GestorArchivo(String path) {
            this.path = path;
            this.generarArchivo();
    }

    public GestorArchivo() {
        this.path = "/home/pablo/Escritorio/Copia_de_Horario_de_clase_por_grupos.xls";
        this.generarArchivo();
    }

    private void generarArchivo() {
        File file = new File(this.path);

        if(file.exists()) {
            this.file = file;
            System.out.println("Archivo generado.");
        } else {
            this.file = null;
            System.err.println("El archivo no existe.");
        }
    }

    public XSSFWorkbook getLibro() throws IOException {
        FileInputStream fis = new FileInputStream(this.file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        return wb;
    }
}