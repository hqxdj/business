package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description: ta
 * @Date 2019/8/7 9:57
 * Copyright (c)   xdj
 */

public class Who<T> implements InvocationHandler {

    private T target;

    public Object getWho(T target) {
        this.target =target;
       Object t =  Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);;
        System.out.println(t);
        return   Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }

}
