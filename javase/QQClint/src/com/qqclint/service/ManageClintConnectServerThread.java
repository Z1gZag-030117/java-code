package com.qqclint.service;

import java.util.HashMap;

public class ManageClintConnectServerThread {
    private static HashMap<String, ClintConnectServerThread> hm = new HashMap<>();


    public static void addClintConnectServerThread(String userID, ClintConnectServerThread clintConnectServerThread) {
        hm.put(userID, clintConnectServerThread);
    }

    //通过userID得到对应线程
    public static ClintConnectServerThread getClintConnectServerThread(String userID) {
        return hm.get(userID);
    }

}
