package p186;

public class PingpangCoatch extends Coatch implements SpeakEnglish{
    public PingpangCoatch() {
    }

    public PingpangCoatch(String name, int age) {
        super(name, age);
    }

    @Override
    public void teath() {
        System.out.println("乒乓球教练教乒乓球");
    }

    @Override
    public void eat() {
        System.out.println("乒乓球教练吃乒乓球");
    }

    @Override
    public void speak() {
        System.out.println("乒乓球教练学英语");
    }
}
