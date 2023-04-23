package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 朱喆
 * @version 1.0
 */
public class ProxyUtil {

    public static Star createProxy(BigStar bigStar){
//        参数:
//        loader – the class loader to define the proxy class
//        interfaces – the list of interfaces for the proxy class to implement
//        h – the invocation handler to dispatch method invocations to
//        代理的方法由invoke决定
        Star starProxy=(Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("sing")){
                        System.out.println("准备话筒");
                    }else if (method.getName().equals("dance")){
                        System.out.println("准备场地");
                    }
                    return method.invoke(bigStar,args);
                });
        return starProxy;
    }

}
