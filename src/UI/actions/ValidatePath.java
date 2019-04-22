package UI.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import UI.controller.UIController;
import UI.models.Colors;

public class ValidatePath implements ActionListener {
	private UIController controller;

	public ValidatePath(UIController controller) {
		this.controller = controller;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.setFilePath();
		this.controller.processFile();
	}

}
