package UI.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import UI.actions.AddAction;
import UI.actions.ChooseFile;
import UI.actions.ExecuteFilter;
import UI.actions.GenerateDB;
import UI.actions.RemoveAction;
import UI.actions.SelectAction;
import UI.actions.SelectFilter;
import UI.actions.SelectOutput;
import UI.view.UI;
import controller.comandos.ComandoCrearTablaCurso;
import controller.comandos.ComandoCrearTablaDia;
import controller.comandos.ComandoCrearTablaHora;
import controller.comandos.ComandoCrearTablaHorario;
import controller.comandos.ComandoExtraerCursos;
import controller.comandos.ComandoExtraerHorarios;
import controller.comandos.ComandoFiltro;
import controller.comandos.ComandoInsertarHoras;
import controller.comandos.ComandoInsertarDias;
import controller.filtros.Filtros;
import controller.gestor.GestorArchivoXLS;
import controller.reflexion.CargadorComandos;
import modelo.application.Messages;
import util.Debug;

public class UIController extends UI {
	private static final long serialVersionUID = 9027661565874661995L;

	private String filePath;
	private String outputPath;
	private Debug debug;
	private XSSFWorkbook wb;
	private Filtros filtro;
	private ArrayList<ComandoFiltro> commands;

	public UIController() {
		this.debug = Debug.getDebug();
		this.debug.disable();

		this.addListeners();
		this.createFilterCommands();
		this.populateFilterList();
		this.initialState();
	}

	/**
	 * Estado inicial de los botones
	 */
	private void initialState() {
		this.btnScan.setEnabled(false);
		this.listFilters.setEnabled(false);
		this.btnAddAction.setEnabled(false);
		this.btnGenerate.setEnabled(false);
		this.btnRemoveAction.setEnabled(false);
	}

	/**
	 * Añadir listeners a los componentes
	 */
	private void addListeners() {
		this.btnChooseFile.addActionListener(new ChooseFile(this, this.fileDialog));
		this.btnScan.addActionListener(new ExecuteFilter(this));
		this.listFilters.addListSelectionListener(new SelectFilter(this));
		this.btnAddAction.addActionListener(new AddAction(this));
		this.btnRemoveAction.addActionListener(new RemoveAction(this));
		this.btnGenerate.addActionListener(new GenerateDB(this));
		this.btnSeleccionarSalida.addActionListener(new SelectOutput(this));
		this.listActions.addListSelectionListener(new SelectAction(this));
	}

	/**
	 * Procesar el fichero seleccionado.
	 */
	public void processFile() {
		StringBuilder info = new StringBuilder();
		GestorArchivoXLS g = new GestorArchivoXLS(this.filePath);

		if (g.isValido()) {
			this.listFilters.setEnabled(true);

			try {
				ArrayList<XSSFWorkbook> libros = g.getLibros();
				this.wb = libros.get(0);
				this.filtro = new Filtros(wb);
				info.append("Libros: " + libros.size());

				int sheets = 0;
				for (XSSFWorkbook libro : libros) {
					sheets += libro.getNumberOfSheets();
				}
				info.append(", Hojas: " + sheets);

			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setFileInfo(info.toString());
		} else {
			this.setFileInfo(Messages.InvalidFile.toString());
			this.listFilters.setEnabled(false);
			this.btnScan.setEnabled(false);
		}
	}

	/**
	 * Crea los filtros de la lista de filtros
	 */
	private void createFilterCommands2() {
		this.commands = new ArrayList<>();

		this.commands.add(new ComandoCrearTablaCurso());
		this.commands.add(new ComandoCrearTablaHorario());
		this.commands.add(new ComandoCrearTablaDia());
		this.commands.add(new ComandoCrearTablaHora());
		this.commands.add(new ComandoInsertarHoras());
		this.commands.add(new ComandoInsertarDias());
		this.commands.add(new ComandoExtraerHorarios());
		this.commands.add(new ComandoExtraerCursos());
	}
	
	private void createFilterCommands() {
		this.commands = new CargadorComandos("controller.comandos").getFilters();
	}

	/**
	 * Añade los filtros a la lista de filtros
	 */
	private void populateFilterList() {
		DefaultListModel<ComandoFiltro> listModel = new DefaultListModel<>();

		for (ComandoFiltro command : this.commands) {
			listModel.addElement(command);
		}

		this.listFilters.setModel(listModel);
	}

	public void setFileInfo(String info) {
		this.lblInfo.setText(info);
	}

	public JList getListFilter() {
		return this.listFilters;
	}
	
	public JList getListActions() {
		return this.listActions;
	}
	
	public void refreshListActions() {
		this.listActions.repaint();
	}

	public void setScanButtonEnabled(boolean enabled) {
		this.btnScan.setEnabled(enabled);
	}
	
	public void setAddActionEnabled(boolean enabled) {
		this.btnAddAction.setEnabled(enabled);
	}

	public void setFilePath(String path) {
		this.filePath = path;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public XSSFWorkbook getWorkbook() {
		return this.wb;
	}

	public Filtros getFiltro() {
		return this.filtro;
	}

	public void setTxtResults(String results) {
		this.txtPaneResults.setText("");
		this.txtPaneResults.setText(results);
	}
	
	public String getOutputDBPath() {
		return this.outputPath;
	}
	
	public void setOutputPath(String path) {
		this.outputPath = path;
	}
	
	public void showOutputPath(String path) {
		this.lblOutputPath.setText(path);
	}
	
	public void setGenerateDBEnabled(boolean enabled) {
		this.btnGenerate.setEnabled(enabled);
	}
	
	public void setRemoveActionEnabled(boolean enabled) {
		this.btnRemoveAction.setEnabled(enabled);
	}

}
