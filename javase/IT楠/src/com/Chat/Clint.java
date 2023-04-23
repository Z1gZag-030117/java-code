package com.Chat;

import com.Chat.Contant.Constant;
import com.Chat.Contant.MassageType;
import com.Chat.util.MsgUtils;
import com.Chat.util.ScannerUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Clint {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        //链接服务器
        socket.connect(new InetSocketAddress(8888));
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
//        System.out.println("请您选择功能 "+
//                MassageType.LOGAN+"·登录  "+
//                MassageType.TO_SERVER+"·发送给服务器  " +
//                MassageType.TO_FRIEND+"·发送给好友  "+
//                MassageType.TO_ALL+"·群发");

        String username = null;

        //登录
        while (true) {
            if (username == null) {
                username = login(outputStream, inputStream);
            }else {
                printOrder();
                String num = ScannerUtil.input();
                switch (Integer.parseInt(num)){
                    case MassageType.TO_SERVER:
                        sendToServer(username,outputStream,inputStream);
                        break;
                    case MassageType.TO_FRIEND:
                        sendToFriend(username,outputStream,inputStream);
                        break;
                    case MassageType.TO_ALL:
                        sendToAll(username,outputStream,inputStream);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void sendToAll(String username,OutputStream outputStream, InputStream inputStream) {

    }

    private static void sendToFriend(String username,OutputStream outputStream, InputStream inputStream) {

    }

    private static void sendToServer(String username,OutputStream outputStream, InputStream inputStream) {
        System.out.print(username+":");
        String msg = ScannerUtil.input();
        MsgUtils.writeMsg(outputStream,new Massage(MassageType.TO_SERVER,msg,username));
        Optional<Massage> msg1 = MsgUtils.readMsg(inputStream);
        msg1.ifPresent(massage -> System.out.println(massage.getUserName()+":"+massage.getContent()));
    }

    private static void printOrder() {
        System.out.println("请您选择功能 "+
        MassageType.TO_SERVER+"·发送给服务器  " +
        MassageType.TO_FRIEND+"·发送给好友  "+
        MassageType.TO_ALL+"·群发");
    }

    private static String login(OutputStream outputStream, InputStream inputStream) throws IOException {
        System.out.println("请您登录");
        System.out.println("请输入用户名：");
        String name = ScannerUtil.input();
        System.out.println("请输入密码：");
        String password = ScannerUtil.input();
        Massage massage = new Massage();
        massage.setType(MassageType.LOGAN);
        massage.setUserName(name);
        massage.setPassWord(password);
        MsgUtils.writeMsg(outputStream, massage);
        //接受来自服务端的消息
        Optional<Massage> msg = MsgUtils.readMsg(inputStream);
        if (msg.isPresent() && Constant.SUCCESS.equals(msg.get().getContent())) {
            return name;
        }
        return null;
    }

}
