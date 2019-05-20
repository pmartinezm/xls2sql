package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JList;

import UI.controller.UIController;
import filtros.Filtros;
import filtros.comandos.ComandoFiltro;
import interfaces.IFiltros;

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
