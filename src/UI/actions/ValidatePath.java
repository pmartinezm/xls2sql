package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.controller.UIController;

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
