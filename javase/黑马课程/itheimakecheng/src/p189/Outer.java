package p189;

public class Outer {
    private int num=10;

    public class Inner{
        public void show(){
            System.out.println(num);
        }

    }

    public void meyhod(){
        //show();
        Inner i=new Inner();
        i.show();
    }

}
