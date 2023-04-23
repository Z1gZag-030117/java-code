package com.qqservice;


import com.qqcommom.Message;
import com.qqcommom.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ServerConnectClintThread extends Thread {
    private Socket socket;
    private String userID;//链接服务端的用户

    public ServerConnectClintThread(Socket socket, String userID) {
        this.socket = socket;
        this.userID = userID;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务器和客户" + userID + "端保持通信");
                ObjectInputStream ois = new ObjectInputStream(
                        socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) { //客户需要在线用户列表
                    System.out.println("用户" + message.getSender() + "需要在线用户列表");
                    String onlineUser = ManageClintThread.getOnlineUsers();
                    Message message1 = new Message();
                    message1.setMessageType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);
                    message1.setGetter(message.getSender());
                    ObjectOutputStream oos = new ObjectOutputStream(
                            socket.getOutputStream());
                    oos.writeObject(message1);
                } else if (message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + "要退出系统");
                    //将客户端对应的线程从集合中删除
                    ManageClintThread.removeServerConnectClintThread(userID);
                    socket.close();
                    //退出线程
                    break;
                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //System.out.println(message.toString());
                    ServerConnectClintThread scct = ManageClintThread.getServerConnectClintThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(
                            scct.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMessageType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //需要遍历管理线程的集合，得到所有线程的socket，并发送message
                    HashMap<String, ServerConnectClintThread> hm = ManageClintThread.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String onLineUser = iterator.next().toString();
                        if (!onLineUser.equals(message.getSender())) {
                            ObjectOutputStream oos = new ObjectOutputStream(
                                    hm.get(onLineUser).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMessageType().equals(MessageType.MESSAGE_FILE_MES)) {
                    ServerConnectClintThread scct = ManageClintThread.getServerConnectClintThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(scct.getSocket().getOutputStream());
                    oos.writeObject(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
