package com.maming.common.util;

/**
 * 时间转换成int
 * 二进制转换工具类
 */
public class DateConvertInt {

    /**
     * int+char组成的long二进制
     * 将年月日时分秒使用32+16个字节进行组装成一个long值
     * @param value  2016121223
     * @param value2  5959
     */
    private static long bytesToInt(int value,char value2) {
    	System.out.println(value);
    	System.out.println("value:"+Long.toBinaryString(value));
        
        //将两个int组装成一个long
        String result = Long.toBinaryString(value)+Long.toBinaryString(value2 & 0xFFFF);
        System.out.println("result:"+result);
        return Long.parseLong(result,2);
    }
    
    /**
     * 将指定1111的二进制,转换成FF类型的16进制
     */
    public static void binaryToHex(){
    	long value = Long.parseLong("11111111111111111111111111111111111111111111111111111111",2);//先转换成10进制
    	//对10进制转换成16进制
    	System.out.println("0x"+Long.toHexString(value).toUpperCase());
    }
 
	public static void main(String[] args) {
		int date = 2016121223;
		char time = 5959;
		bytesToInt(date,time);
		binaryToHex();
		
	}
}
