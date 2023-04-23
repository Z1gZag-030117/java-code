package com.Socket;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class SocketTest {

    @Test
    public void inetAddressTest() throws UnknownHostException {
        InetAddress address=InetAddress.getLoopbackAddress();//获取回环地址
        System.out.println("address = " + address);
        InetAddress[] baidu = InetAddress.getAllByName("www.baidu.com");
        System.out.println(Arrays.toString(baidu));
        InetAddress[] localhost = InetAddress.getAllByName("localhost");
        System.out.println(Arrays.toString(localhost));
        byte[] bytes={127,0,0,1};
        InetAddress byAddress = InetAddress.getByAddress(bytes);
        System.out.println(byAddress);
    }


    @Test
    public void serverTest() throws IOException {
        //创建ServerSocket端口
        ServerSocket socket=new ServerSocket();
        //绑定在摸一个端口
        socket.bind(new InetSocketAddress(InetAddress.getLoopbackAddress(),8888));
        //监听这个端口
        Socket accept=socket.accept();
    }





}
