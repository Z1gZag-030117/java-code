package p237;

import java.util.LinkedList;

public class link {
    public static void main(String[] args) {

        LinkedList<String> link=new LinkedList<String>();

        link.add("hello");
        link.add("word");
        link.add("java");

//        link.addFirst("zhuzhe");
//        link.addLast("sn");

//        System.out.println(link.getFirst());
//        System.out.println(link.getLast());

        System.out.println(link.removeFirst());
        System.out.println(link.removeLast());




        System.out.println(link);
    }
}
