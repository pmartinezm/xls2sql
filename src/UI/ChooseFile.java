package UI;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseFile implements ActionListener {
	private FileDialog dialog;
	
	public ChooseFile(FileDialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.setMode(FileDialog.LOAD);
	    dialog.setVisible(true);
	    String file = dialog.getDirectory() + dialog.getFile();
	    System.out.println(file);
	}

}
