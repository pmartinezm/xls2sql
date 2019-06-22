package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import UI.controller.UIController;
import controller.interfaces.IComandoFiltro;

/**
 * Elimina una acción de la lista de acciones (script)
 * @author pmartinezmar
 *
 */
public class RemoveAction implements ActionListener {

	private UIController controller;

	public RemoveAction(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selectedIndex = this.controller.getListActions().getSelectedIndex();
		
		if(selectedIndex != -1) {
			DefaultListModel<IComandoFiltro> model = (DefaultListModel<IComandoFiltro>) this.controller.getListActions()
					.getModel();
			model.remove(selectedIndex);
		}
		System.out.println(this.controller.getListActions().getModel());
	}

}
