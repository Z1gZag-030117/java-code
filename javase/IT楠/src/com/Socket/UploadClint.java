package com.Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClint {
    public static void main(String[] args) throws IOException {
//        Socket socket=new Socket(InetAddress.getLocalHost(),8888);
//        String filePath="C:\\Users\\zhu zhe\\Pictures\\Camera Roll\\高考暑假旅游\\IMG_E0076.JPG";
//        BufferedInputStream bis=new BufferedInputStream(
//                new FileInputStream(filePath));
//        byte[] bytes = StreamUtil.streamToByteArray(bis);
//        BufferedOutputStream bos=new BufferedOutputStream(
//                socket.getOutputStream());
//        bos.write(bytes);
//        InputStream inputStream = socket.getInputStream();
//        String s = StreamUtil.streamToString(inputStream);
//        System.out.println(s);
//        inputStream.close();
//        bis.close();
//        socket.shutdownOutput();
//        bos.close();
//        socket.close();
        String filePath="C:\\Users\\zhu zhe\\Desktop\\，\\图\\7c7a7fd94f151bebf2b011e8ff63e464.jpeg";
        Socket socket=new Socket(InetAddress.getLocalHost(),8888);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes=StreamUtil.streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bis.close();
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtil.streamToString(inputStream);
        System.out.println(s);
        inputStream.close();

        bos.close();
        socket.close();


    }
}
