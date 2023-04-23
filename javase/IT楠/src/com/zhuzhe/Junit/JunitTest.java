package com.zhuzhe.Junit;

import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    @Test
    public void TestOne(){
        int i=0;
        i++;
        Assert.assertEquals(3,i);
    }

}
