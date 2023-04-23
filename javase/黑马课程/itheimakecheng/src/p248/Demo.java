package p248;

import java.util.Comparator;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<score> tr =new TreeSet<score>(new Comparator<score>() {
            @Override
            public int compare(score s1, score s2) {
                //成绩从高到低排序
                float num=(s1.getChinese()+s1.getMath())-(s2.getChinese()+s2.getMath());
                //总分相同判断,按照语文成绩排序
                float num1=num==0?num1=s1.getChinese()-s2.getChinese():num;
                //语文成绩和数学成绩都相同
                float num2=num1==0?s1.getName().compareTo(s2.getName()):num1;
                return (int) num2;
            }
        });

        score s1=new score("zhuzhe",99,98);
        score s2=new score("sn",99,98);
        score s3=new score("zznn",97,99);
        score s4=new score("ssnn",98,98);

        tr.add(s1);
        tr.add(s2);
        tr.add(s3);
        tr.add(s4);


        for (score sc: tr){
            System.out.println(sc.getName()+sc.getChinese()+sc.getMath()+(sc.getChinese()+sc.getMath()));
        }

    }
}
