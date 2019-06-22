
import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import UI.controller.UIController;
import util.Debug;

public class Xls2sql {
	public static void main(String[] args) {
		Debug d = Debug.getDebug();

		if (args.length > 0 && args[0].equalsIgnoreCase("debug")) {
			d.enable();
		} else {
			d.disable();
		}

		d.write("Xls2sql");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIController frame = new UIController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
