package com.maming.common.util;

import org.junit.Test;

public class IpConvertIntTest {

	//将本地ip转换成整数,以及整数转换成ip
	@Test
	public void test1(){
		 int value = IpConvertInt.localIpToInt();
		 System.out.println(value);
		 System.out.println(IpConvertInt.intToIp(value));
	}

	//将指定ip转换成整数,以及整数转换成ip
	@Test
	public void test2(){
		 String ipAddr = "192.168.8.1";
		 int value = IpConvertInt.ipToInt(ipAddr);
		 System.out.println(value);
		 System.out.println(IpConvertInt.intToIp(value));
	}

}
