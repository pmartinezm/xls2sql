package UI.actions;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.controller.UIController;

public class SelectOutput implements ActionListener{
	private UIController controller;
	
	public SelectOutput(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FileDialog d = new FileDialog(this.controller);
		d.setMode(FileDialog.SAVE);
		d.setVisible(true);
		String directory = d.getDirectory();
		String file = d.getFile();
		String path = directory + file;
		this.controller.setOutputPath(path);
		this.controller.showOutputPath(path);
		if(path != null) {
			this.controller.setGenerateDBEnabled(true);
		}
	}

}
