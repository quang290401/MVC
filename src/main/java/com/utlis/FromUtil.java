package com.utlis;


import java.lang.reflect.InvocationTargetException;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;





public class FromUtil {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
		T object = null;
		try {
			object = clazz.newInstance(); // chạy siêu chậm
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.print(e.getMessage());
		}
		return object;
	}
}
