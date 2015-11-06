package com.maming.common.funxing.demo1;

public class Factory {

	public <T> T getObject(Class<T> c) {
		try {
			return c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Factory factory = new Factory();
		/*
		 * try { Stock stock = (Stock)
		 * factory.getObject(Class.forName("com.bigdata.util.Stock"));
		 * stock.diedai(); //Object object =
		 * factory.getObject(Class.forName("com.bigdata.util.Stock"));
		 * //System.out.println(object); } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); }
		 */
		Anamal dog = factory.getObject(Dog.class);
		dog.speak();
		System.out.println(dog);

	}
}
