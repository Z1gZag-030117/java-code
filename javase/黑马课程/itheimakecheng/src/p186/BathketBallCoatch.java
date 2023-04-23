package p186;

public  class BathketBallCoatch extends Coatch{
    public BathketBallCoatch() {
    }

    public BathketBallCoatch(String name, int age) {
        super(name, age);
    }

    @Override
    public void teath() {
        System.out.println("篮球教练教篮球");
    }

    @Override
    public void eat() {
        System.out.println("篮球教练吃篮球");
    }
}
