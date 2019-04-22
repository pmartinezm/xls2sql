package util;

import java.lang.reflect.Method;
import controller.Filtro;
import interfaces.Filtros;

public class Reflex {
	public static Method[] getFilters() {
		Method[] declaredMethods = Filtros.class.getDeclaredMethods();
		return declaredMethods;
	}
}
