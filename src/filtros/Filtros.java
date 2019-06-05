package filtros;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.Buscador;
import controller.Posicionador;
import interfaces.IFiltros;
import modelo.Coordenada;
import modelo.horario.Asignatura;
import modelo.horario.Dia;
import modelo.horario.Hora;
import modelo.horario.Horario;

public class Filtros implements IFiltros {
	private XSSFWorkbook wb;

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
	public ArrayList<Horario> extraerHorarios() {
		final int DIAS = 5;
		final int HORAS = 6;
		int sheets = this.wb.getNumberOfSheets();
		ArrayList<Horario> horarios = new ArrayList<>();

		for (int i = 0; i < sheets; i++) {
			XSSFSheet sheet = this.wb.getSheetAt(i);
			Buscador b = new Buscador(sheet);
			Posicionador p = new Posicionador(sheet);

			Coordenada buscar = b.buscar("tramo horario", 50);

			if (buscar != null) {
				Coordenada current = buscar;
				System.out.println(current);
				Horario Ehorario = new Horario("");
				for (int dia = 0; dia < DIAS; dia++) {
					Dia Edia = new Dia();
					current = p.getSiguienteColumna(current);
					for (int hora = 0; hora < HORAS; hora++) {
						Hora Ehora = new Hora();
						current = p.getSiguienteFila(current);
						Asignatura a = new Asignatura(sheet.getRow(current.r).getCell(current.c).toString());
						Ehora.addAsignatura(a);

						Edia.addHora(Ehora);
					}
					Ehorario.addDia(Edia);
					current.r = buscar.r;
				}
				horarios.add(Ehorario);
			}
		}
		System.out.println("Horarios: " + horarios.size());
		return horarios;
	}

	@Override
	public Object creandoUnFiltro() {
		return null;
	}
}


























