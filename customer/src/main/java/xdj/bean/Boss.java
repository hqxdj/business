package xdj.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 17:26
 * Copyright (c)   xdj
 */
@Component
public class Boss {

    private Car car;

//    @Autowired
    // 默认是调用无惨构造器进行初始化，如果只含有一个有参构造器，则调用改构造器，参数从容器中获取
    public Boss(Car car) {
        System.out.println("Boss中的有参构造器");
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    //    @Autowired
    // 默认是从容器获取属性值进行装配
    public void setCar(Car car) {
        this.car = car;
    }
}
