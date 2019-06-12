package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.controller.UIController;

/**
 * Valida el path, y si es válido, procesa el archivo y precarga los elementos que lo necesiten
 * @author pmartinezmar
 *
 */
public class ValidatePath implements ActionListener {
	private UIController controller;

	public ValidatePath(UIController controller) {
		this.controller = controller;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.processFile();
	}

}
