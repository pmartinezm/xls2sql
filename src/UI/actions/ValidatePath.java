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
		
		String path = this.controller.getFilePath();

		try {
			File file = new File(path);

			if (file.exists()) {
				this.setColor(Colors.ValidPath);
			} else {
				this.setColor(Colors.WrongPath);
			}
		} catch (Exception ex) {
			this.setColor(Colors.WrongPath);
		}
		this.controller.gestor();
	}

	private void setColor(Color color) {
		this.controller.setTxtFilePathBorderColor(color);
	}

}
