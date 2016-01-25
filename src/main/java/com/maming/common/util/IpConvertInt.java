package com.maming.common.util;

import java.net.InetAddress;

public class IpConvertInt {

	private final static int INADDRSZ = 4;

    /**
     * 把IP地址转化为字节数组
     */
    private static byte[] ipToBytes(String ipAddr) {
        try {
            return InetAddress.getByName(ipAddr).getAddress();
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }
    }
    
    /**
     * 本地IP转换成字节数组
     */
    private static byte[] localIpToBytes() {
        try {
            return InetAddress.getLocalHost().getAddress();
        } catch (Exception e) {
            throw new IllegalArgumentException("local is invalid IP");
        }
    }

    /**
     * 把IP地址转化为byte,与ipToBytes方法一致
     */
    @SuppressWarnings("unused")
	private static byte[] ipToBytesByReg(String ipAddr) {
        byte[] ret = new byte[4];
        try {
            String[] ipArr = ipAddr.split("\\.");
            ret[0] = (byte) (Integer.parseInt(ipArr[0]) & 0xFF);
            ret[1] = (byte) (Integer.parseInt(ipArr[1]) & 0xFF);
            ret[2] = (byte) (Integer.parseInt(ipArr[2]) & 0xFF);
            ret[3] = (byte) (Integer.parseInt(ipArr[3]) & 0xFF);
            return ret;
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }

    }

    /**
     * 字节数组转化为IP
     * @param bytes
     * @return int
     */
    private static String bytesToIp(byte[] bytes) {
        return new StringBuffer().append(bytes[0] & 0xFF).append('.')
        		.append(bytes[1] & 0xFF).append('.')
                .append(bytes[2] & 0xFF).append('.')
                .append(bytes[3] & 0xFF).toString();
    }

    /**
     * 根据位运算把 byte[] -> int
     */
    private static int bytesToInt(byte[] bytes) {
        int addr = bytes[3] & 0xFF;
        addr |= ((bytes[2] << 8) & 0xFF00);
        addr |= ((bytes[1] << 16) & 0xFF0000);
        addr |= ((bytes[0] << 24) & 0xFF000000);
        return addr;
    }

    /**
     * 把IP地址转化为int
     */
    public static int ipToInt(String ipAddr) {
        try {
            return bytesToInt(ipToBytes(ipAddr));
        } catch (Exception e) {
            throw new IllegalArgumentException(ipAddr + " is invalid IP");
        }
    }

    /**
     * 把本地IP地址转化为int
     */
    public static int localIpToInt() {
        try {
            return bytesToInt(localIpToBytes());
        } catch (Exception e) {
            throw new IllegalArgumentException("local is invalid IP");
        }
    }
    
    /**
     * 把int转换成字节数组
     */
    private static byte[] intToBytes(int ipInt) {
        byte[] ipAddr = new byte[INADDRSZ];
        ipAddr[0] = (byte) ((ipInt >>> 24) & 0xFF);
        ipAddr[1] = (byte) ((ipInt >>> 16) & 0xFF);
        ipAddr[2] = (byte) ((ipInt >>> 8) & 0xFF);
        ipAddr[3] = (byte) (ipInt & 0xFF);
        return ipAddr;
    }

    /**
     * 把int转换成ip
     * @param ipInt
     * @return String
     */
    public static String intToIp(int ipInt) {
    	return bytesToIp(intToBytes(ipInt));
    }
}
