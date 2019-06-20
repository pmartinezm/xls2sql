package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListModel;

import UI.controller.UIController;
import controller.database.DBController;
import controller.interfaces.IComandoFiltro;

/**
 * Ejecuta las acciones de la lista de acciones (script) y genera la base de datos
 * @author pmartinezmar
 *
 */
public class GenerateDB implements ActionListener {
	private UIController controller;
	
	public GenerateDB(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ListModel model = this.controller.getListActions().getModel();
		DBController dbc = new DBController(this.controller.getOutputDBPath());
		
		for(int i = 0; i < model.getSize(); i++) {
			IComandoFiltro filter = (IComandoFiltro) model.getElementAt(i);
			String query = filter.ejecutar(this.controller.getFiltro());
			dbc.sendQuery(query);
		}
	}
}
