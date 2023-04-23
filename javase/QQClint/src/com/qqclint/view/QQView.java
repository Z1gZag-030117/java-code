package com.qqclint.view;

import com.qqclint.service.FileClintService;
import com.qqclint.service.MessageClintServer;
import com.qqclint.service.UserClintService;
import com.qqclint.utils.Utility;

public class QQView {
    private boolean loop = true;//控制是否否显示菜单
    private String key = "";//接受用户输入
    private UserClintService userClintService = new UserClintService();//此对象用于登录服务器/注册用户
    private MessageClintServer messageClintServer = new MessageClintServer();//该对象用于私聊
    private FileClintService fileClintService = new FileClintService();//用于传输文件

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("退出。。。");
    }

    private void mainMenu() {
        while (loop) {
            System.out.println("---------菜单---------");
            System.out.println("\t\t1.登录");
            System.out.println("\t\t9.退出");
            System.out.print("输入你的选择:");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userID = Utility.readString(20);
                    System.out.print("请输入密  码：");
                    String userPassword = Utility.readString(20);
                    if (userClintService.checkUser(userID, userPassword)) {
                        System.out.println("\n----------欢迎用户" + userID + "--------");
                        while (loop) {
                            System.out.println("\n--------二级菜单 (用户1" + userID + ")-------");
                            System.out.println("\t\t1.显示在线用户列表");
                            System.out.println("\t\t2.群发消息");
                            System.out.println("\t\t3.私聊消息");
                            System.out.println("\t\t4.发送文件");
                            System.out.println("\t\t9.退出");
                            System.out.print("输入你的选择:");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    //System.out.println("显示在线用户列表");
                                    userClintService.getOnlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("-------群发消息-------");
                                    System.out.print("输入群聊的内容:");
                                    String s = Utility.readString(200);
                                    messageClintServer.sendMessageToAll(s, userID);
                                    break;
                                case "3":
                                    System.out.println("-------私聊消息-------");
                                    System.out.print("输入在线的私聊用户号：");
                                    String getterUserID = Utility.readString(20);
                                    System.out.print("输入聊天内容:");
                                    String content = Utility.readString(200);
                                    messageClintServer.sendMessageToOne(content, userID, getterUserID);
                                    break;
                                case "4":
                                    //System.out.println("发送文件");
                                    System.out.println("请输入你想把文件发送给的用户：");
                                    getterUserID = Utility.readString(50);
                                    System.out.println("请输入你想发送文件的路径(形式 d:\\xx.jpg)：");
                                    String src = Utility.readString(100);
                                    System.out.println("请输入把文件发送到对方的路径(形式 d:\\xx.jpg):");
                                    String dest = Utility.readString(100);
                                    fileClintService.sendFileToOne(src, dest, userID, getterUserID);
                                    break;
                                case "9":
                                    userClintService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }

}
