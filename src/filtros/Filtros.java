package filtros;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.Buscador;
import controller.Posicionador;
import interfaces.IFiltros;
import modelo.Coordenada;
import util.GeneradorSQL;

public class Filtros implements IFiltros {
	private XSSFWorkbook wb;
	private int horariosCounter = 0;
	private int cursosCounter = 0;
	private ArrayList<String> cursos;

	public Filtros() {

	}

	public Filtros(XSSFWorkbook wb) {
		this.wb = wb;
	}

	@Override
	public int contarHorarios() {
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
		return counter;
	}

	@Override
	public int contarCursos() {
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
		return counter;
	}

	@Override
	public ArrayList<String> extraerCursos() {
		int sheets = this.wb.getNumberOfSheets();
		ArrayList<String> cursos = new ArrayList<>();

		for (int i = 0; i < sheets; i++) {
			XSSFSheet sheet = this.wb.getSheetAt(i);

			Buscador b = new Buscador(sheet);
			Coordenada coord = b.buscar("Enseñanza:", 5);

			if (coord != null) {
				Posicionador p = new Posicionador(sheet);
				int sigCol = p.getSiguienteColumna(coord.r, coord.c);
				String celda = sheet.getRow(coord.r).getCell(sigCol).toString();

				cursos.add(celda);
			}
		}

		return cursos;
	}

	@Override
	public Object extraerHorarios() {
		final int DIAS = 5;
		final int HORAS = 6;
		int sheets = this.wb.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			XSSFSheet sheet = this.wb.getSheetAt(i);
			Buscador b = new Buscador(sheet);
			Posicionador p = new Posicionador(sheet);

			Coordenada buscar = b.buscar("tramo horario", 50);

			if (buscar != null) {
				Coordenada current = buscar;
				System.out.println(current);
				for(int dia = 0; dia < DIAS; dia++) {
					for(int hora = 0; hora < HORAS; hora++) {
						current = p.getSiguienteColumna(current);
						current = p.getSiguienteFila(current);
						String casilla = sheet.getRow(current.r).getCell(current.c).toString();
						//System.out.println(casilla);
						System.out.println(current);
					}
				}
			}

		}

		return null;
	}
}
