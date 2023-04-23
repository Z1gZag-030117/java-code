package p192;

public class Outer {

    public void method() {


        Inter i = new Inter() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }
        };
        i.show();
        i.show();//用i多次调用

//                @Override
//                public void show() {
//                    System.out.println("匿名内部类");
//                }
//            }.show();


    }
}
