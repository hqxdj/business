package xdj.bean;

import org.springframework.stereotype.Component;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:50
 * Copyright (c)   xdj
 */
@Component
public class Car {

    public Car() {
        System.out.println("调用了Car的constructor");
    }

    public void init(){
        System.out.println("调用了init");
    }

    public void destroy(){
        System.out.println("调用了destroy");
    }
}
