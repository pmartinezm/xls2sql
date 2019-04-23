package modelo;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.Buscador;
import interfaces.IFiltros;

public class Filtro implements IFiltros {
	private XSSFWorkbook wb;
	private int horariosCounter = 0;
	private int cursosCounter = 0;

	public Filtro() {

	}

	public Filtro(XSSFWorkbook wb) {
		this.wb = wb;
	}

	@Override
	public void contarHorarios() {
		int sheets = this.wb.getNumberOfSheets();
		int counter = 0;

		for (int i = 0; i < sheets; i++) {
			XSSFSheet current = wb.getSheetAt(i);
			Buscador b = new Buscador(current);

			Coordenada coords = b.buscar("Tramo horario", 20);

			if (coords != null) {
				counter++;
			}
		}

		System.out.println("Encontrados " + counter + " horarios.");
		this.horariosCounter = counter;
	}

	@Override
	public void contarCursos() {
		int sheets = this.wb.getNumberOfSheets();
		int counter = 0;

		for (int i = 0; i < sheets; i++) {
			XSSFSheet current = this.wb.getSheetAt(i);
			Buscador b = new Buscador(current);

			Coordenada coord = b.buscar("Enseñanza:", 5);

			if (coord != null) {
				counter++;
			}
		}
		this.cursosCounter = counter;
	}

	public int getCursosCounter() {
		return this.cursosCounter;
	}

	public int getHorariosCounter() {
		return this.horariosCounter;
	}
}
