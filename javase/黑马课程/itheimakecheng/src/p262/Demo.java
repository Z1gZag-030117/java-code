package p262;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        //创建hashmap集合对象
        HashMap<String, Student> hm = new HashMap<String, Student>();

        //创建学生对象
        Student s1 = new Student("zz", 20);
        Student s2 = new Student("sn", 21);
        Student s3 = new Student("ssnn", 22);

        //把学生添加到集合内
        hm.put("01", s1);
        hm.put("02", s2);
        hm.put("03", s3);

        //键查询
        Set<String> keySet = hm.keySet();//获取所有键的集合
        for (String key : keySet) {
            Student value = hm.get(key);
            System.out.println(key + "," + value.getName() + "," + value.getAge());
        }

        Set<Map.Entry<String, Student>> entrySet = hm.entrySet();
        for(Map.Entry<String, Student> s:entrySet){
            String key = s.getKey();
            Student value = s.getValue();
            System.out.println(key + "," + value.getName() + "," + value.getAge() );
        }


    }
}
