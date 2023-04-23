package com.zhuzhe.API;

import java.math.BigDecimal;

public class CalculateUtil {
    public static Double plus(double n1,double n2){
        BigDecimal bigDecimal=new BigDecimal(Double.toString(n1));
        BigDecimal add = bigDecimal.add(new BigDecimal(Double.toString(n2)));
        return add.doubleValue();
    }
}
