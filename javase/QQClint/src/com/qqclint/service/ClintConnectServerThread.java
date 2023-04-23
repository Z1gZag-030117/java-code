package com.qqclint.service;

import com.qqcommom.Message;
import com.qqcommom.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClintConnectServerThread extends Thread {

    //该线程持有socket
    private Socket socket;

    public ClintConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //线程在后台和服务器通信，使用while循环
        while (true) {
            try {
                System.out.println("客户端线程，等待从读取从服务器发来的消息");
                ObjectInputStream ois = new ObjectInputStream(
                        socket.getInputStream());
                //如果服务器没有发送消息，线程会阻塞在这里
                Message message = (Message) ois.readObject();
                if (message.getMessageType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("--------当前在线用户--------");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println((i + 1) + ".用户:" + onlineUsers[i]);
                    }
                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)) {
                    System.out.println("\n" + message.getTime() + message.getSender() + " 对 " + message.getGetter() + " 说:" + message.getContent());
                } else if (message.getMessageType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //显示
                    System.out.println("\n" + message.getTime() + message.getSender() + " 对所有人说：" + message.getContent());
                } else if (message.getMessageType().equals(MessageType.MESSAGE_FILE_MES)) {
                    System.out.println("\n" + message.getSender() + "给" + message.getGetter() + "发送文件：" + message.getSrc() + "到电脑目录" + message.getDest());

                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n保存文件成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
