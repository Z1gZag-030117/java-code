package p245;

public class TreeSet {
    public static void main(String[] args) {
        java.util.TreeSet<Integer> ts=new java.util.TreeSet<Integer>();

        ts.add(10);
        ts.add(23);
        ts.add(345);
        ts.add(1);
        ts.add(50);
        ts.add(34);

        for(Integer i:ts){
            System.out.println(i);
        }




    }
}
