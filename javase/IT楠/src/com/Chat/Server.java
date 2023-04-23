package com.Chat;

import com.Chat.Contant.Constant;
import com.Chat.Contant.MassageType;
import com.Chat.util.MsgUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    public static final Map<String, Socket> USERS = new ConcurrentHashMap<>(8);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket();
        //绑定端口
        serverSocket.bind(new InetSocketAddress(8888));
        System.out.println("服务器已启动");
        //开始监听
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Optional<Massage> massage = MsgUtils.readMsg(inputStream);
            if (massage.isPresent()){
                Massage msg=massage.get();
                switch (msg.getType()){
                    case MassageType.LOGAN:
                        loginHandler(inputStream,outputStream);
                        break;
                    case MassageType.TO_SERVER:
                        sendToClint(inputStream,outputStream);
                        break;
                    case MassageType.TO_FRIEND:
                        sendToTarget(inputStream,outputStream);
                        break;
                    case MassageType.TO_ALL:
                        sendToAll(inputStream,outputStream);
                        break;
                }
            }

            //判断登录
            if (!massage.isPresent() || massage.get().getUserName() == null || !massage.get().getPassWord().equals("123")) {
                MsgUtils.writeMsg(outputStream, new Massage(MassageType.FROM_SERVER, Constant.FAIL, "server"));
                continue;
            } else {
                Massage msg = massage.get();
                USERS.put(msg.getUserName(), socket);
                System.out.println(msg.getUserName()+Constant.SUCCESS);
                MsgUtils.writeMsg(outputStream, new Massage(MassageType.FROM_SERVER, Constant.SUCCESS, "server"));
            }
            //massage.ifPresent(System.out::println);
        }

    }

    private static void sendToAll(InputStream inputStream, OutputStream outputStream) {
        
    }

    private static void sendToTarget(InputStream inputStream, OutputStream outputStream) {

    }

    private static void sendToClint(InputStream inputStream, OutputStream outputStream) {

    }

    private static void loginHandler(InputStream inputStream, OutputStream outputStream) {

    }
}
