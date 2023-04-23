package pool;

public class UserDao2 extends BaseDaoImpl<User> implements BetterBaseDao<User>{

    public static void main(String[] args) {
        UserDao2 userDao2=new UserDao2();
        userDao2.sava(new User(2,"sn",124));
    }
}
