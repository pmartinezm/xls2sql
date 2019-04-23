package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JList;

import UI.controller.UIController;
import interfaces.IFiltros;
import modelo.Filtro;

public class ExecuteFilter implements ActionListener, IFiltros{
	private UIController controller;

	public ExecuteFilter(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JList listFilter = this.controller.getListFilter();
		String selected = (String) listFilter.getSelectedValue();

		try {
			Method method = this.getClass().getDeclaredMethod(selected, null);
			method.invoke(this, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void contarHorarios() {
		Filtro f = new Filtro(this.controller.getWorkbook());
		f.contarHorarios();
		int horarios = f.getHorariosCounter();
		this.controller.setTxtResults("Horarios encontrados: " + horarios);
	}

	@Override
	public void contarCursos() {
		Filtro f = new Filtro(this.controller.getWorkbook());
		f.contarCursos();
		int cursos = f.getCursosCounter();
		this.controller.setTxtResults("Cursos encontrados: " + cursos);
	}

}
