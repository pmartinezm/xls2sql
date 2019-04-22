package UI.actions;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import UI.controller.UIController;

public class SelectFilter implements ListSelectionListener {
	private UIController controller;

	public SelectFilter(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (this.controller.getListFilter().getSelectedIndex() != -1) {
			this.controller.setScanButtonEnabled(true);
		} else {
			this.controller.setScanButtonEnabled(false);
		}
	}

}
