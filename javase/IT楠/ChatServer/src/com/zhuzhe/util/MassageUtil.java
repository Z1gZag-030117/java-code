package com.zhuzhe.util;

import com.zhuzhe.Massage;

import java.io.*;
import java.util.Optional;

public class MassageUtil {
    public static Optional<Massage> readMassage(InputStream inputStream) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            return Optional.ofNullable((Massage) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static void writeMassage(OutputStream outputStream,Massage massage){
        ObjectOutputStream objectOutputStream=null;
        try{
           objectOutputStream=new ObjectOutputStream(outputStream);
           objectOutputStream.writeObject(massage);
           objectOutputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
