package com.qqservice;


import com.qqcommom.Message;
import com.qqcommom.MessageType;
import com.qqcommom.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {
    private ServerSocket serverSocket;
    private static ConcurrentHashMap<String, User> concurrentHashMap = new ConcurrentHashMap<>();
    private static HashMap<String, User> validUsers = new HashMap<>();

    static {
        validUsers.put("100", new User("100", "123"));
        validUsers.put("200", new User("200", "321"));
        validUsers.put("300", new User("300", "111"));
        validUsers.put("400", new User("400", "000"));
    }

    private boolean checkUser(String userID, String password) {
        User user = validUsers.get(userID);
        if (user == null) {
            return false;
        }
        if (!user.getPassWord().equals(password)) {
            return false;
        }
        return true;
    }

    public QQServer() {
        try {
            System.out.println("在9999端口监听");
            serverSocket = new ServerSocket(8888);
            //启动推送消息的线程
            new Thread(new SendNewsToService()).start();
            while (true) { //和客户端建立连接后一直监听
                Socket socket = serverSocket.accept();
                //获得socket关联的输入流
                ObjectInputStream ois = new ObjectInputStream(
                        socket.getInputStream());
                User u = (User) ois.readObject(); //读取客户端发来的用户对想

                ObjectOutputStream oos = new ObjectOutputStream(
                        socket.getOutputStream());
                //创建message回复客户端
                Message message = new Message();
                if (checkUser(u.getUserId(), u.getPassWord())) {
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    //创建一个线程和客户端保持链接,并持有socket对象
                    ServerConnectClintThread scct = new ServerConnectClintThread(socket, u.getUserId());
                    scct.start();
                    ManageClintThread.addClintThread(u.getUserId(), scct);
                } else {
                    System.out.println("用户" + u.getUserId() + "密码" + u.getPassWord() + "登录失败");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
