package com.zhuzhe.homework;

public class SuperLink {

    private Node head;
    private int currentIndex=-1;



    public void add(int data){

        if (head==null){
            head =new Node(data,null);
        }else {
            Node node=new Node(data,head);
            head=node;
        }
        currentIndex++;
    }

    public void delete(int index){
        if(index==0){
            head=head.getNext();
        }else {
            Node node=head;
            for (int i = 0; i < index-1; i++) {
                node=node.getNext();
            }
            node.setNext(node.getNext().getNext());
        }
        currentIndex--;
    }

    public int select(int index){
        Node node=head;
        for (int i = 0; i < index; i++) {
            node.getNext();
        }
        return node.getData();
    }

    public void set(int index,int data){
        Node node=head;
        for (int i = 0; i < index; i++) {
            node.setData(data);
        }
        node.setData(data);
    }

    public int size(){
        return currentIndex++;
    }




}
