package util;

import java.lang.reflect.Method;
import controller.Filtro;

public class Reflex {
	public static Method[] getFilters() {
		Method[] declaredMethods = new Filtro().getClass().getDeclaredMethods();
		return declaredMethods;
	}
}
