package com.maming.common.base.fatherson.demo1;


public class SonSuccess extends Factory{
	
	private String hour = "-1";

	public SonSuccess(String[] args){
		super(args);
		init2(args);
	}
	
	@Override
	public void init(String[] args) {
		super.setStatDate(args[0]);
		System.out.println("-init--");
	}
	
	public void init2(String[] args) {
		hour = args[1];
		System.out.println("init:"+this.hour);
	}
	
	@Override
	protected void constStatement() {
		System.out.println("xxx");
		System.out.println(this.statDate);
		System.out.println(this.hour);
	}
	
}
