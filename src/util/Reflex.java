package util;

import java.lang.reflect.Method;

import interfaces.IFiltros;
import modelo.Filtro;

public class Reflex {
	public static Method[] getFilters() {
		Method[] declaredMethods = IFiltros.class.getDeclaredMethods();
		return declaredMethods;
	}
}
