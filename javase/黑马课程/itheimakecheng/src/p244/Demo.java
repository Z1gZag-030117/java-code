package p244;

import java.util.LinkedHashSet;

public class Demo  {
    public static void main(String[] args) {
        LinkedHashSet<String> lh=new LinkedHashSet<String>();

        lh.add("hello");
        lh.add("word");
        lh.add("java");

        for(String s:lh){
            System.out.println(s);
        }
    }
}
