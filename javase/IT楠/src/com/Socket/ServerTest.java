package com.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket=new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        User u = (User) objectInputStream.readObject();
        System.out.println(u.toString());
        socket.close();
        serverSocket.close();
    }
}
