package com.qqclint.service;

import com.qqcommom.Message;
import com.qqcommom.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 朱喆
 * @version 1.0
 * 完成文件传输
 */
public class FileClintService {

    public void sendFileToOne(String dest, String src, String senderID, String getterID) {

        //读取src文件
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderID);
        message.setGetter(getterID);
        message.setSrc(src);
        message.setDest(dest);
        //System.out.println(message);

        //读取文件
        byte[] fileBytes = new byte[(int) new File(src).length()];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClintConnectServerThread.getClintConnectServerThread(senderID)
                    .getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n" + message.getSender() + "给" + getterID + "发送文件：" + src + "到对方的电脑目录" + dest);
    }
}
