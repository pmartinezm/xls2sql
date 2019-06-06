package UI.controller;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import UI.actions.AddAction;
import UI.actions.ChooseFile;
import UI.actions.ExecuteFilter;
import UI.actions.SelectFilter;
import UI.actions.ValidatePath;
import filtros.Filtros;
import filtros.comandos.ComandoContarCursos;
import filtros.comandos.ComandoContarHorarios;
import filtros.comandos.ComandoCrearTablaCurso;
import filtros.comandos.ComandoCrearTablaHorario;
import filtros.comandos.ComandoExtraerCursos;
import filtros.comandos.ComandoExtraerHorarios;
import filtros.comandos.ComandoFiltro;
import gestor.GestorArchivoXLS;
import modelo.Colors;
import modelo.Messages;
import util.Debug;
import util.Reflex;

public class UIController extends UI {
	private static final long serialVersionUID = 9027661565874661995L;

	private String filePath;
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

	private void initialState() {
		this.btnScan.setEnabled(false);
		this.listFilters.setEnabled(false);
		this.btnAddAction.setEnabled(false);
		this.btnRemoveAction.setEnabled(false);
		this.btnGenerate.setEnabled(false);
	}

	private void addListeners() {
		this.btnChooseFile.addActionListener(new ChooseFile(this, this.fileDialog));
		this.btnScan.addActionListener(new ExecuteFilter(this));
		this.listFilters.addListSelectionListener(new SelectFilter(this));
		this.btnAddAction.addActionListener(new AddAction(this));
	}

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

	private void createFilterCommands() {
		this.commands = new ArrayList<>();

		this.commands.add(new ComandoContarCursos());
		this.commands.add(new ComandoContarHorarios());
		this.commands.add(new ComandoExtraerCursos());
		this.commands.add(new ComandoExtraerHorarios());
		this.commands.add(new ComandoCrearTablaCurso());
		this.commands.add(new ComandoCrearTablaHorario());
	}

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

	/**
	 * Sets file path
	 * 
	 * @param path
	 */
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

}
