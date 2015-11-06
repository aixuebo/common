package com.maming.common.funxing.demo2;

import java.lang.reflect.ParameterizedType;

public abstract class Factory<T> {

	protected Class<T> entityClass;
	private T instance;

	@SuppressWarnings("unchecked")
	public void init() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		instance = emptyInstance();
	}

	public T emptyInstance() {
		try {
			return entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public T getInstance() {
		return instance;
	}
}
