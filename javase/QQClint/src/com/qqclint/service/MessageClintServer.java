package com.qqclint.service;

import com.qqcommom.Message;
import com.qqcommom.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MessageClintServer {

    public void sendMessageToOne(String content, String senderID, String getterID) {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderID);
        message.setGetter(getterID);
        message.setContent(content);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        message.setTime(simpleDateFormat.format(new Date()) + "\r\n");
        System.out.println(senderID + " 对 " + getterID + "说: " + content);
        //System.out.println(message.toString());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClintConnectServerThread.getClintConnectServerThread(senderID).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAll(String content, String senderID) {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(senderID);
        message.setContent(content);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        message.setTime(simpleDateFormat.format(new Date()) + "\r\n");
        System.out.println(senderID + " 对所有人说:" + content);
        //System.out.println(message.toString());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClintConnectServerThread.getClintConnectServerThread(senderID).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
