package com.Chat.util;

import com.Chat.Massage;

import java.io.*;
import java.util.Optional;

public class MsgUtils {

    public static Optional<Massage> readMsg(InputStream inputStream) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            return Optional.ofNullable((Massage) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static void writeMsg(OutputStream outputStream, Massage massage) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(massage);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
