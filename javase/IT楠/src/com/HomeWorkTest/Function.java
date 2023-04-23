package com.HomeWorkTest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Function {

    public static void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入商品的编号：");
        int id = scanner.nextInt();
        System.out.println("输入商品的名称：");
        String name = scanner.next();
        System.out.println("输入商品的价格：");
        int price = scanner.nextInt();
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(Shop.PATH, true);
            String goods = id + " " + name + " " + price + "\r\n";
            outputStream.write(goods.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入查看商品的编号：");
        int id = scanner.nextInt();
        Optional<Goods> first = getAllGoods().stream().filter(g -> g.getId() == id).findFirst();
        first.ifPresent(goods -> System.out.println(goods.getId() + "号 " + goods.getName() + " " + goods.getPrice() + "元"));
    }

    public static void showAll() {
        List<Goods> list = getAllGoods();
        for (Goods goods : list) {
            System.out.println(goods.getId() + "号 " + goods.getName() + " " + goods.getPrice() + "元");
        }
    }

    public static void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入想要删除商品的编号：");
        int id = scanner.nextInt();
        List<Goods> list = getAllGoods();
        Iterator<Goods> iterator = list.iterator();
        while (iterator.hasNext()) {
            Goods goods = iterator.next();
            if (goods.getId() == id) {
                iterator.remove();
            }
        }
        flash(list);
    }

    public static void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入想要修改的商品的编号：");
        int id = scanner.nextInt();
        System.out.println("输入想要修改的商品的名称：");
        String name=scanner.next();
        System.out.println("输入想要修改的商品的价格：");
        int price = scanner.nextInt();
        List<Goods> list=getAllGoods();
        Iterator<Goods> iterator = list.iterator();
        while(iterator.hasNext()){
            Goods goods = iterator.next();
            if(goods.getId()==id){
                goods.setName(name);
                goods.setPrice(price);
            }
        }
        flash(list);
    }

    private static List<Goods> getAllGoods() {
        List<Goods> goodsList = new ArrayList<>();
        try (Reader reader = new FileReader(Shop.PATH);
             BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            String pergoods;
            while ((pergoods = bufferedReader.readLine()) != null) {
                String[] goodsElement = pergoods.split(" ");
                Goods goods = new Goods(Integer.parseInt(goodsElement[0]),
                        goodsElement[1],
                        Integer.parseInt(goodsElement[2]));
                goodsList.add(goods);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    private static void flash(List<Goods> list){
        try (Writer writer = new FileWriter(Shop.PATH);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            for (Goods goods : list) {
                bufferedWriter.write(goods.getId() + " " + goods.getName() + " " + goods.getPrice());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
