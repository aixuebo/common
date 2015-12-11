package org.apach.spark.util;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class StackTraceTest {

	@Test
	public void test1(){
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>();
		map.put("aa", "aaa12");
		map.put("bb", "bbb12");
		
		System.out.println(map.putIfAbsent("cc", "ccc"));
		System.out.println(map.putIfAbsent("aa", "aaa22222"));
		
		System.out.println(map);
		StackTraceElement[] StackTraceElementArr = Thread.currentThread().getStackTrace();
		for(StackTraceElement stack:StackTraceElementArr){
			//打印哪个方法,在哪行,哪个文件
			System.out.println(stack+"=="+stack.getMethodName()+"==="+stack.getLineNumber()+"=="+stack.getClassName()+"=="+stack.getFileName());
		}
	}
	
	@Test
	public void test2(){
		System.out.println("sss");
		String str = "from_unixtime(cast(substr(a.clicktime,1,10)) as bigint),";
		System.out.println(str.substring(43));
	}
}
