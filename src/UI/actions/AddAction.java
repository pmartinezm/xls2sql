package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import UI.controller.UIController;
import controller.comandos.ComandoFiltro;

/**
 * Añadir una acción a la lista de acciones (script)
 * @author pmartinezmar
 *
 */
public class AddAction implements ActionListener {
	private UIController controller;

	public AddAction(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ComandoFiltro selectedFilter = (ComandoFiltro) this.controller.getListFilter().getSelectedValue();
		if (selectedFilter != null) {
			ListModel<ComandoFiltro> oldModel = this.controller.getListActions().getModel();
			
			DefaultListModel<ComandoFiltro> model = new DefaultListModel<>();
			for(int i = 0; i < oldModel.getSize(); i++) {
				model.addElement(oldModel.getElementAt(i));
			}
			model.addElement(selectedFilter);
			this.controller.getListActions().setModel(model);
		}
		this.controller.refreshListActions();
	}

}
