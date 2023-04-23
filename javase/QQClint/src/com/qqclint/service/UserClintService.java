package com.qqclint.service;


import com.qqcommom.Message;
import com.qqcommom.MessageType;
import com.qqcommom.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UserClintService {

    private User u = new User();
    private Socket socket;


    public boolean checkUser(String userID, String userPassword) {
        //创建user对象
        u.setUserId(userID);
        u.setPassWord(userPassword);
        //System.out.println(u.toString());
        boolean flag = false;

        try {
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            ObjectOutputStream oos = new ObjectOutputStream(
                    socket.getOutputStream());
            oos.writeObject(u);//发送user对象给服务器

            //读取服务器回复的消息
            ObjectInputStream ois = new ObjectInputStream(
                    socket.getInputStream());

            Message message = (Message) ois.readObject();
            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) { //登录成功
                //创建一个和服务器端通信的线程
                ClintConnectServerThread ccst =
                        new ClintConnectServerThread(socket);
                //启动线程
                ccst.start();
                //将线程放到集合中
                ManageClintConnectServerThread.addClintConnectServerThread(userID, ccst);
                flag = true;
            } else {
                //登录失败
                socket.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    //1.向服务器请求在线客户列表
    public void getOnlineFriendList() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //System.out.println(message.toString());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClintConnectServerThread.getClintConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //退出方法,退出客户端并给服务端发送退出程序的message对象
    public void logout() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());

        //发送message
        try {
//            ObjectOutputStream oos = new ObjectOutputStream(
//                    socket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClintConnectServerThread.getClintConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + "退出系统");
            System.exit(0);//结束
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
