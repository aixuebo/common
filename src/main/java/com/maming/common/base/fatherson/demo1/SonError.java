package com.maming.common.base.fatherson.demo1;

/**
 * 子类定义了属性hour,调用init初始化,但是最后生成的值依然是错误的
 * 原因是:因为编译器会先调用父类,然后再调用子类,因此逻辑是调用父类的init方法,然后加载子类,此时虽然hour =9,但是由于重新加载子类,因此hour又变成了-1,因此异常。
 * 
 * 解决方案:
 * 方案:设计上子类就要初始化子类的,父类初始化父类的,不要做交叉即可
 */
public class SonError extends Factory{
	
	private String hour = "-1";

	public SonError(String[] args){
		super(args);
	}
	
	@Override
	public void init(String[] args) {
		super.setStatDate(args[0]);
		System.out.println("-init--");
		hour = args[1];
		System.out.println("init:"+this.hour);
	}
	
	
	@Override
	protected void constStatement(){
		System.out.println("xxx");
		System.out.println(this.statDate);
		System.out.println(this.hour);
	}
	
}
