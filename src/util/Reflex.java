package util;

import java.lang.reflect.Method;

import filtros.Filtros;
import interfaces.IFiltros;

public class Reflex {
	public static Method[] getFilters() {
		Method[] declaredMethods = IFiltros.class.getDeclaredMethods();
		return declaredMethods;
	}
}
