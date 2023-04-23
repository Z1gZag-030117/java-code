package com.IO;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOTest {
    public static void main(String[] args) {

    }

    @Test
    public void fileInputStream_(){
        String filePath="F:\\java\\IO.txt";
        int read=0;
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream(filePath);
            while((read = fileInputStream.read())!=-1){
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testRead() throws IOException {
        File file = new File("F:\\java\\Test.txt");
        InputStream inputStream = new FileInputStream(file);
        int read;
        byte[] bytes = new byte[3];
        while ((read = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, read));
        }
    }

    @Test
    public void writeTest() throws IOException {

        byte[] bytes = {97, 98, 99, 100};
        OutputStream outputStream = new FileOutputStream("F:\\java\\Test.txt");
        OutputStream outputStream1 = new FileOutputStream("F:\\java\\Test.txt", true);//追加
        //覆盖原来的数据
        outputStream.write(97);
        outputStream.write(bytes);
        outputStream1.write(bytes);
        outputStream1.write("hello word".getBytes(StandardCharsets.UTF_8));
        //outputStream.write("zz".getBytes(StandardCharsets.UTF_8));
    }


    @Test
    public void copyFileTest() throws IOException {
        File file1 = new File("F:\\java\\testa\\IOtest.MOV");
        File file2 = new File("F:\\java\\testb\\IOtest.MOV");
        //把输入流建立在文件上
        InputStream inputStream = new FileInputStream(file1);
        //建立一个输出流
        OutputStream outputStream = new FileOutputStream(file2);
        //建立缓冲区
        int len;
        //byte[] bytes = new byte[1042];
        //int read = inputStream.read(bytes);//返回一个一次读取的长度
        long start = System.currentTimeMillis();
        while ((len = inputStream.read()) != -1) {
            outputStream.write(len);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }

    @Test
    public void copyFileTest2() {

        //把输入流建立在文件上
        InputStream inputStream = null;
        //建立一个输出流
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("F:\\java\\testa\\IOtest.MOV");
            outputStream = new FileOutputStream("F:\\java\\testb\\IOtest.MOV");
            //建立缓冲区
            //int b;
            byte[] bytes = new byte[1024];
            int read ;//返回一个一次读取的长度,读了多少个
            long start = System.currentTimeMillis();
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Test
    public void copyFileTest3() {
        try (
             InputStream inputStream = new FileInputStream("F:\\java\\testa\\IOtest.MOV");
             OutputStream outputStream = new FileOutputStream("F:\\java\\testb\\IOtest.MOV")) {
            //建立缓冲区
            //int b;
            byte[] bytes = new byte[1024];
            int read;//返回一个一次读取的长度,读了多少个
            long start = System.currentTimeMillis();
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readerTest() throws IOException {

        Reader reader = new FileReader("F:\\java\\testa\\a.txt");
        Writer writer = new FileWriter("F:\\java\\testb\\a.txt");
        int b;
        while ((b = reader.read()) != -1) {
            writer.write(b);
        }
        reader.close();
        writer.close();
    }


    @Test
    public void bufferReaderTest() throws IOException {
        Reader reader = new FileReader("F:\\java\\testa\\a.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
//        Writer writer=new FileWriter("F:\\java\\testb\\a.txt");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
            System.out.println("_______________");
        }
        reader.close();
        bufferedReader.close();
    }


    @Test
    public void objectTest() throws IOException {
        OutputStream outputStream = new FileOutputStream("F:\\java\\testa\\a.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        //写一个对象到磁盘中
        objectOutputStream.writeObject(new User(1, "zz "));
        outputStream.close();
    }

    @Test
    public void objectTest2() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("F:\\java\\testa\\a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        User user = (User) objectInputStream.readObject();
        System.out.println(user);
        inputStream.close();
        objectInputStream.close();
    }


}
