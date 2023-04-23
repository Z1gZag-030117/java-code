package p171;

public class AnimalOperator {
//       public void useAnimla (Cat c){
//           c.eat();
//       }
//
//       public void useAnimal (Dog d){
//           d.eat();
//       }

        public void useAnimal(Animal a){
            //animal a=new Cat（多态）

            //成员方法编译看左边，Animal a里有eat这个方法
            //运行看右边，Cat里有eat这个方法，方法内容为输出猫吃鱼
            a.eat();
        }



}
