import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegexp {

    @Test
    public void test() {
        String context = "my name is zigzag come from csgo";
        String regexp = ".*zigzag.*";
        Pattern pattern = Pattern.compile(regexp); //编译一个正则表达式，获得编译后的结果、
        Matcher matcher = pattern.matcher(context);
        System.out.println(matcher.matches());
    }

    @Test
    public void text2() {
        String context = "zz is zz";
        String regexp = "zz";
        String replace = "sn";
        Pattern compile = Pattern.compile(regexp);
        Matcher matcher = compile.matcher(context);
        String s = matcher.replaceAll(replace);
        System.out.println(s);
        String s1 = matcher.replaceFirst(replace);
        System.out.println(s1);
    }

    @Test
    public void test3() {
        String regex = ".+(?=</span>)";
        String context = "<span class=\"read-count\">阅读数：641</span>";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(context);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void test4() {
        String regex = "\\d+(?=</span>)";
        String context = "<span class=\"read-count\">阅读数：641</span>";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(context);
        while (matcher.find()) {
            System.out.println(matcher.group());

        }
    }

    @Test
    public void testAssert3() {
        String regex = "(?<=<span class=\"read-count\">阅读数：)\\d+";
        String context = "<span class=\"read-count\">阅读数：641</span>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void test5() {
        String context = "021-51259875    022-48569213";
        String regex = "(0\\d{2})-(\\d{8})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()) {
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }

    @Test
    public void test6() {
        String context = "021-51259875    022-48569213";
        String regex = "(?<areacode>0\\d{2})-(?<phonenumber>\\d{8})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()) {
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            for (int i = 0; i <= matcher.groupCount(); i++) {
//                System.out.println(matcher.group(i));
//            }
            System.out.println(matcher.group("areacode"));
            System.out.println(matcher.group("phonenumber"));
        }
    }

    @Test
    public void test7() {
        String context = "021-51259875    022-48569213";
        String regex = "(?:0\\d{2})-(\\d{8})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        while (matcher.find()) {
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }


    @Test
    public void homeWork() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = new FileInputStream("F:\\java\\Test.txt");
        byte[] buf = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) > 0) {
            stringBuffer.append(new String(buf, 0, len));
        }
        String regex = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringBuffer.toString());
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void testInPutStream() throws IOException {
        File file=new File("F:\\java\\Test.txt");
        InputStream inputStream=new FileInputStream(file);
        int read ;
        byte[] buf=new byte[1024];
        while ((read= inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,read));
        }
    }

    @Test
    public void testOutPutStream() throws IOException {
        byte[] bytes={97,98,99,100};
        OutputStream outputStream=new FileOutputStream("F:\\java\\Test.txt",true);
        outputStream.write(bytes);
        outputStream.write("\r\n追加".getBytes());
    }


}
