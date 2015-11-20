package com.maming.common.base.fatherson.demo1;

public abstract class Factory {

	protected String statDate = null;
	
	public Factory(String[] args){
		init(args);
	}
	
	public abstract void init(String[] args);

	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}
	
	protected void constStatement() {
			
	}
}
