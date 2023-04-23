package p255;

public class Demo {
    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println(sum(10,20));
        System.out.println(sum(10,20,30));
        System.out.println(sum(10,20,30,40));




    }

    public static int sum(int b,int ...a){
//        System.out.println(a);
          int sum=0;
          for(int i:a)
          {
              sum+=i;
          }
        return sum;
    }






}
