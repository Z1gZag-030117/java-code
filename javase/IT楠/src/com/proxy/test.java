package com.proxy;

/**
 * @author 朱喆
 * @version 1.0
 */
public class test {

    public static void main(String[] args) {

        BigStar bigStar=new BigStar("sn");
        Star proxy = ProxyUtil.createProxy(bigStar);

        String sing = proxy.sing("1111");
        System.out.println(sing);

        proxy.dance();

    }

}
