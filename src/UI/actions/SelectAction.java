package UI.actions;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import UI.controller.UIController;

/**
 * A la escucha de selecci�n de una acci�n de la lista de acciones para el comportamiento de los botones.
 * @author pmartinezmar
 *
 */
public class SelectAction implements ListSelectionListener {
	private UIController controller;

	public SelectAction(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (this.controller.getListActions().getSelectedIndex() != -1) {
			this.controller.setRemoveActionEnabled(true);
		} else {
			this.controller.setRemoveActionEnabled(false);
		}
	}

}
