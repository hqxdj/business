package xdj;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xdj.bean.Boss;
import xdj.bean.Car;
import xdj.bean.Color;
import xdj.config.MainConfigAutowire;
import xdj.config.MainConfigLifeCycle;
import xdj.service.BookService;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:55
 * Copyright (c)   xdj
 */

public class MainAutowiredTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAutowire.class);

    @Test
    public void test() {
//        printBeans(context);
        BookService bean = context.getBean(BookService.class);
        System.out.println(bean);
        Boss boss = context.getBean(Boss.class);
        Car car = context.getBean(Car.class);
        Color color = context.getBean(Color.class);
        System.out.println(color);
        System.out.println(car);
        System.out.println(boss);

    }

    private void printBeans(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
    }
}