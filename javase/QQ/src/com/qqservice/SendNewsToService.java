package com.qqservice;

import com.qqcommom.Message;
import com.qqcommom.MessageType;
import com.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 朱喆
 * @version 1.0
 */
public class SendNewsToService implements Runnable {


    @Override
    public void run() {
        while (true) {
            System.out.print("请输入服务器推送的消息[输入exit退出]：");
            String news = Utility.readString(100);
            if (news.equals("exit")) {
                break;
            }
            Message message = new Message();
            message.setMessageType(MessageType.MESSAGE_TO_ALL_MES);
            message.setContent(news);
            message.setSender("服务器");
            message.setTime(new Date().toString());
            System.out.println("服务器发送消息对所有人说：" + news);

            //遍历当前所有在线线程
            HashMap<String, ServerConnectClintThread> hm = ManageClintThread.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onLineUserID = iterator.next();
                ServerConnectClintThread serverConnectClintThread = hm.get(onLineUserID);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClintThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
