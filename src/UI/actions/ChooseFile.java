package UI.actions;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.controller.UIController;

public class ChooseFile implements ActionListener {
	private FileDialog fileDialog;
	private UIController controller;

	public ChooseFile(UIController controller, FileDialog fileDialog) {
		this.fileDialog = fileDialog;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.fileDialog.setMode(FileDialog.LOAD);
		this.fileDialog.setVisible(true);

		String directory = this.fileDialog.getDirectory();
		String file = this.fileDialog.getFile();
		String path = directory + file;

		this.controller.setFilePath(path);		
		this.controller.processFile();
	}
}
