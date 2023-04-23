package com.jdbc;

public class notice {
    private int ID;
    private int userID;
    private String content;

    public notice(int ID, int userID, String content) {
        this.ID = ID;
        this.userID = userID;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "notice{" +
                "ID=" + ID +
                ", userID=" + userID +
                ", content='" + content + '\'' +
                '}';
    }
}
