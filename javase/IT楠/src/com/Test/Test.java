package com.Test;

import javafx.scene.Parent;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Test {

    protected static int count=0;
    public Test(){count++;
        System.out.println(count);}
}

class Demo2 extends Test{

}

class Demo extends Test {

    public Demo(){count++;
        System.out.println(count);}

    public static void main(String[] args) {
        Demo x=new Demo();
        Test test1=new Test();
        Test test=new Demo();
        System.out.println("count="+x.count);

        System.out.println(test instanceof Demo2);

        /**
         * Pine
         * Tree
         * Oops
         */

    }

}
