package p215;

public class TryCatch {
    public static void main(String[] args) {
        System.out.println("kaishi");
        show();
        System.out.println("jieshu");
    }

    public static void show(){
        try{
        int []a={1,2,3};
        System.out.println(a[3]);}
        catch (ArrayIndexOutOfBoundsException a){
        //    System.out.println("youwu");
        a.printStackTrace();
        }

    }

}
