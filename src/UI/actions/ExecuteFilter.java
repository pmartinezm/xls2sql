package UI.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JList;

import UI.controller.UIController;
import controller.Filtro;

public class ExecuteFilter implements ActionListener{
	private UIController controller;
	
	public ExecuteFilter(UIController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JList listFilter = this.controller.getListFilter();
		String selected = (String) listFilter.getSelectedValue();
		Filtro instance = new Filtro();
		
		try {
			Method method = instance.getClass().getDeclaredMethod(selected, null);
			method.invoke(instance, null);
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
