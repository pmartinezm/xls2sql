package UI.controller;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import UI.actions.ChooseFile;
import UI.actions.ValidatePath;
import gestor.GestorArchivo;
import util.Debug;

public class UIController extends UI {
	private static final long serialVersionUID = 9027661565874661995L;

	private String filePath;
	private Debug debug;

	public UIController() {
		this.debug = Debug.getDebug();
		this.addListeners();
	}

	private void addListeners() {
		this.btnChooseFile.addActionListener(new ChooseFile(this, this.fileDialog));
		this.btnValidatePath.addActionListener(new ValidatePath(this));
	}

	public void setTxtFilePathBorderColor(Color color) {
		this.txtFilePath.setBorder(null);
		this.txtFilePath.setBorder(new LineBorder(color));
	}

	public void setFilePath(String path) {
		this.filePath = path;
	}
	
	public void setFilePath() {
		this.filePath = this.txtFilePath.getText();
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void showFilePath() {
		this.txtFilePath.setText(this.filePath);
	}
	
	public void setFileInfo(String info) {
		this.lblInfo.setText(info);
	}
	
	public void gestor() {
		StringBuilder info = new StringBuilder();
		GestorArchivo g = new GestorArchivo(this.filePath);
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
		
	}
}
