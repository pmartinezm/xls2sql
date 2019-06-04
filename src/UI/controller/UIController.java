package UI.controller;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import UI.actions.ChooseFile;
import UI.actions.ExecuteFilter;
import UI.actions.SelectFilter;
import UI.actions.ValidatePath;
import filtros.Filtros;
import filtros.comandos.ComandoContarCursos;
import filtros.comandos.ComandoContarHorarios;
import filtros.comandos.ComandoCrearTablas;
import filtros.comandos.ComandoExtraerCursos;
import filtros.comandos.ComandoExtraerHorarios;
import filtros.comandos.ComandoFiltro;
import gestor.GestorArchivo;
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
	}

	private void addListeners() {
		this.btnChooseFile.addActionListener(new ChooseFile(this, this.fileDialog));
		this.btnValidatePath.addActionListener(new ValidatePath(this));
		this.btnScan.addActionListener(new ExecuteFilter(this));
		this.listFilters.addListSelectionListener(new SelectFilter(this));
	}

	public void showFilePath() {
		this.txtFilePath.setText(this.filePath);
	}

	public void processFile() {
		StringBuilder info = new StringBuilder();
		GestorArchivo g = new GestorArchivo(this.filePath);

		if (g.isValido()) {
			this.setTxtFilePathBorderColor(Colors.ValidPath);
			this.listFilters.setEnabled(true);

			try {
				ArrayList<XSSFWorkbook> libros = g.getLibros();
				this.wb = libros.get(0);
				this.filtro = new Filtros(wb);
				info.append("Books: " + libros.size());

				int sheets = 0;
				for (XSSFWorkbook libro : libros) {
					sheets += libro.getNumberOfSheets();
				}
				info.append(", Sheets: " + sheets);

			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setFileInfo(info.toString());
		} else {
			this.setTxtFilePathBorderColor(Colors.WrongPath);
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
		this.commands.add(new ComandoCrearTablas());
	}

	private void populateFilterList() {
		DefaultListModel<ComandoFiltro> listModel = new DefaultListModel<>();
		
		for(ComandoFiltro command: this.commands){
			listModel.addElement(command);
		}
		
		this.listFilters.setModel(listModel);
	}

	private void populateFilterList2() {
		Method[] filters = Reflex.getFilters();
		DefaultListModel<String> listModel = new DefaultListModel<>();

		for (Method method : filters) {
			String name = method.getName();
			listModel.addElement(name);
		}

		this.listFilters.setModel(listModel);
	}

	public void setTxtFilePathBorderColor(Color color) {
		//this.txtFilePath.setBorder(null);
		this.txtFilePath.setBorder(new LineBorder(color));
	}

	public void setFileInfo(String info) {
		this.lblInfo.setText(info);
	}

	public JList getListFilter() {
		return this.listFilters;
	}

	public void setScanButtonEnabled(boolean enabled) {
		this.btnScan.setEnabled(enabled);
	}

	/**
	 * Sets file path
	 * 
	 * @param path
	 */
	public void setFilePath(String path) {
		this.filePath = path;
	}

	/**
	 * Gets path from txt and assigns it to the path variable.
	 */
	public void setFilePath() {
		this.filePath = this.txtFilePath.getText();
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
