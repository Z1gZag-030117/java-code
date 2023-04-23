package p186;

public class PingpangPlayer extends Player implements SpeakEnglish{
    public PingpangPlayer() {
    }

    public PingpangPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("学乒乓球");
    }

    @Override
    public void eat() {
        System.out.println("吃乒乓球");
    }

    @Override
    public void speak() {
        System.out.println("说英语");
    }
}
