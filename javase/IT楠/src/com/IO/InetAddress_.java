package com.IO;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 朱喆
 * @version 1.0
 */
public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress host1 = InetAddress.getByName("www.baidu.com");
        System.out.println(host1);
    }
}
