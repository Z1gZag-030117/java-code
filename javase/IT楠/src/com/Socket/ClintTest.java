package com.Socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClintTest {
    public static void main(String[] args) throws IOException {
        User user=new User("1","1");
        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(user);
        socket.close();
    }
}
