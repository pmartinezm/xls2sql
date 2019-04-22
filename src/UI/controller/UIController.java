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
import UI.controller.file.FileValidator;
import UI.models.Colors;
import gestor.GestorArchivo;
import lang.Messages;
import util.Debug;
import util.Reflex;

public class UIController extends UI {
	private static final long serialVersionUID = 9027661565874661995L;

	private String filePath;
	private Debug debug;

	public UIController() {
		this.debug = Debug.getDebug();
		this.addListeners();
		this.populateFilterList();
		this.initialState();
	}

	private void initialState() {
		this.setScanButtonEnabled(false);
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

		if (g.estado()) {
			this.setTxtFilePathBorderColor(Colors.ValidPath);

			try {
				ArrayList<XSSFWorkbook> libros = g.getLibros();
				info.append("Books: " + libros.size());

				int sheets = 0;
				for (XSSFWorkbook libro : libros) {
					sheets += libro.getNumberOfSheets();
				}
				info.append(", Sheets: " + sheets);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setFileInfo(info.toString());
		} else {
			this.setTxtFilePathBorderColor(Colors.WrongPath);
			this.setFileInfo(Messages.InvalidFile.toString());
		}
	}

	private void populateFilterList() {
		Method[] filters = Reflex.getFilters();
		DefaultListModel<String> listModel = new DefaultListModel<>();

		for (Method method : filters) {
			listModel.addElement(method.getName());
		}

		this.listFilters.setModel(listModel);
	}

	public void setTxtFilePathBorderColor(Color color) {
		this.txtFilePath.setBorder(null);
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

}
