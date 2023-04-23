package com.Socket;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class SendPractice {

    public static void main(String[] args) throws IOException {
        //创建发送端的socket对象
        DatagramSocket datagramSocket=new DatagramSocket();

        //封装录入键盘的数据
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line=bufferedReader.readLine())!=null){
            if ("886".equals(line)){
                break;
            }
            //创建数据并把数据打包
            byte[] bytes=line.getBytes();
            DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length, InetAddress.getByName("10.30.4.186"),12345);

            //调用DatagramSocket对象的方法发送数据
            datagramSocket.send(datagramPacket);

            //关闭
            datagramSocket.close();
         }
    }

}
