package jdkProxy;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 10:30
 * Copyright (c)   xdj
 */

public class Test {
    public static void main(String[] args) {
        Person o = (Person) new Who<Me>().getWho(new Me());
        o.eat();

    }
}
