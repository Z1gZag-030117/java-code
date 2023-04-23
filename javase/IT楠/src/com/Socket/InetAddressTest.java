package com.Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress address = InetAddress.getByName("zz");
        String hostName = address.getHostName();
        String hostAddress = address.getHostAddress();

        System.out.println("主机名："+hostName);
        System.out.println("IP地址："+hostAddress);

    }

}
