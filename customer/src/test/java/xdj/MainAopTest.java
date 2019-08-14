package xdj;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xdj.aop.MathCalculator;
import xdj.bean.Boss;
import xdj.bean.Car;
import xdj.bean.Color;
import xdj.config.MainConfigAutowire;
import xdj.config.MainConfigOfAOP;
import xdj.service.BookService;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:55
 * Copyright (c)   xdj
 */

public class MainAopTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

    @Test
    public void test() {
//        printBeans(context);
        MathCalculator bean = context.getBean(MathCalculator.class);
        bean.div(1,1);

    }

    private void printBeans(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
    }
}