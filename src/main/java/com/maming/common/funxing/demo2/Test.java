package com.maming.common.funxing.demo2;

public class Test {

	public ReadInterface test1(String type){
		
		ReadInterface readInterface = null;
		if("cpsh".equals(type)){
			PersonFactory personFactory = new PersonFactory();
			readInterface =
	            new InterfaceDemo<PersonFactory,Person>(personFactory);
		} else if("cpsh".equals(type)){
			PersonFactory personFactory = new PersonFactory();
			readInterface =
	            new InterfaceDemo<PersonFactory,Person>(personFactory);
		}
		
        return readInterface;
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.test1("cpsh");
	}
}
