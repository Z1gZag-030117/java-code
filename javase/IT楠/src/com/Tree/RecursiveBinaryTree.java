package com.Tree;

import java.util.Stack;

public class RecursiveBinaryTree {

    private static class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }


    //递归遍历（每一个节点都是先左后右）
    private static void recursive(Node node) {
        if (node == null) {
            return;
        }

        recursive(node.left);
        recursive(node.right);
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    private static void pre(Node node){
        Stack<Node> stack=new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            node = stack.pop(); //弹出根节点
            System.out.println(node.data);
            if (node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }


        }


    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

//        preOrder(root);
//        System.out.println("----------");
//        inOrder(root);
//        System.out.println("----------");
//        postOrder(root);
        pre(root);

    }

}
