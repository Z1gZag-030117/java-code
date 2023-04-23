package p238;

import java.util.HashSet;
import java.util.Set;

public class setremake {
    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();

        set.add("hello");
        set.add("word");
        set.add("java");

        for(String s:set){
            System.out.println(s);
        }
    }
}
