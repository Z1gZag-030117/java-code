package com.qqservice;

import java.util.HashMap;
import java.util.Iterator;

public class ManageClintThread {

    private static HashMap<String, ServerConnectClintThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClintThread> getHm() {
        return hm;
    }

    public static void addClintThread(String userID, ServerConnectClintThread scct) {
        hm.put(userID, scct);
    }

    public static ServerConnectClintThread getServerConnectClintThread(String userID) {
        return hm.get(userID);
    }

    public static String getOnlineUsers() {
        //便利hashmap
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }

    public static void removeServerConnectClintThread(String userID) {
        hm.remove(userID);
    }
}
