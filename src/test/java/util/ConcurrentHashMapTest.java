package util;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class ConcurrentHashMapTest {

	@Test
	public void test1(){
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>();
		map.put("aa", "aaa12");
		map.put("bb", "bbb12");
		
		System.out.println(map.putIfAbsent("cc", "ccc"));
		System.out.println(map.putIfAbsent("aa", "aaa22222"));
		
		System.out.println(map);
	}
}
