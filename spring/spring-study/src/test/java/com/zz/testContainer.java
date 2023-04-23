package com.zz;

import org.junit.Test;

/**
 * @author 朱喆
 * @version 1.0
 */
public class testContainer {


    @Test
    public void test1() {

        PeopleContainer.MAP.put("UserDao", new UserDaoImpl());
        Object userDao = PeopleContainer.MAP.get("UserDao");

    }


}
