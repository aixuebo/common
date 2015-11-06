package com.maming.common.mock;

public class Controller {
	
	private Service service = null;
	
	public void controll(Person person){
		System.out.println(person.getName()+"=="+person.getSex());
		System.out.println("service.add():"+service.add());
		
		System.out.println(service.getMap());
	}
}
