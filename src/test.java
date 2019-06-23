import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\Pablo\\git\\xls2sql\\Copia_de_Horario_de_clase_por_grupos(8).xlsx");
		if(f.exists()) {			
			XSSFWorkbook wb;
			try {
				wb = new XSSFWorkbook(f);
				int sheets = wb.getNumberOfSheets();
				System.out.println("Sheets: " + sheets);
				XSSFCell cell = wb.getSheetAt(0).getRow(14).getCell(9);
				System.out.println("Cell: " + cell);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
