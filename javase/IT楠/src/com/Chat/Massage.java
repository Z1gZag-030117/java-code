package com.Chat;

import java.io.Serializable;

public class Massage implements Serializable {

    private static final long serialVersionUID = 5546203568509697613L;
    private Integer type;
    private String content;
    private String userName;
    private String passWord;
    private String friendName;

    public Massage() {
    }

    public Massage(Integer type, String content, String userName, String passWord, String friendName) {
        this.type = type;
        this.content = content;
        this.userName = userName;
        this.passWord = passWord;
        this.friendName = friendName;
    }

    public Massage(Integer type, String content, String userName) {
        this.type = type;
        this.content = content;
        this.userName = userName;
    }

    public Massage(String userName,String passWord,Integer type) {
        this.type = type;
        this.userName = userName;
        this.passWord = passWord;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", friendName='" + friendName + '\'' +
                '}';
    }
}
