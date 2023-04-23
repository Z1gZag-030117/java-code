package com.Socket;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest8 {

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        Socket accept = serverSocket.accept();

    }

}
