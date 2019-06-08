package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import UI.controller.UIController;
import filtros.comandos.ComandoFiltro;

public class RemoveAction implements ActionListener {

	private UIController controller;

	public RemoveAction(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selectedIndex = this.controller.getListActions().getSelectedIndex();
		
		if(selectedIndex != -1) {
			DefaultListModel<ComandoFiltro> model = (DefaultListModel<ComandoFiltro>) this.controller.getListActions()
					.getModel();
			model.remove(selectedIndex);
		}
		System.out.println(this.controller.getListActions().getModel());
	}

}
