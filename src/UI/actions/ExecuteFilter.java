package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import UI.controller.UIController;
import filtros.comandos.ComandoFiltro;

public class ExecuteFilter implements ActionListener {
	private UIController controller;

	public ExecuteFilter(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JList listFilter = this.controller.getListFilter();
		ComandoFiltro selectedValue = (ComandoFiltro) listFilter.getSelectedValue();
		
		String content = selectedValue.ejecutar(this.controller.getFiltro());
		this.controller.setTxtResults(content);
	}

}
