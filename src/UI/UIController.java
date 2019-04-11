package UI;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class UIController extends UI {
	private static final long serialVersionUID = 9027661565874661995L;

	private String filePath;

	public UIController() {
		this.addListeners();
	}

	private void addListeners() {
		this.btnChooseFile.addActionListener(new ChooseFile(this, this.fileDialog));
		this.btnValidatePath.addActionListener(new ValidatePath(this));
	}

	protected void setTxtFilePathBorderColor(Color color) {
		this.txtFilePath.setBorder(null);
		this.txtFilePath.setBorder(new LineBorder(color));
	}

	protected void setFilePath(String path) {
		this.filePath = path;
	}
	
	protected void setFilePath() {
		this.filePath = this.txtFilePath.getText();
	}

	protected String getFilePath() {
		return this.filePath;
	}

	protected void showFilePath() {
		this.txtFilePath.setText(this.filePath);
	}
}
