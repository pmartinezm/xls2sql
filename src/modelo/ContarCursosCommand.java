package modelo;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ContarCursosCommand {
	private String nombre;
	private XSSFWorkbook wb;
	
	public ContarCursosCommand(String nombre, XSSFWorkbook wb) {
		this.nombre = nombre;
		this.wb = wb;
	}
	
	public ContarCursosCommand() {
		
	}
	
	public void exec() {
		new Filtro(this.wb).contarCursos();
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
