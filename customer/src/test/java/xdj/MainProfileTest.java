package xdj;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xdj.bean.Boss;
import xdj.bean.Car;
import xdj.bean.Color;
import xdj.config.MainConfigAutowire;
import xdj.config.MainConfigOfProfile;
import xdj.service.BookService;

import javax.sql.DataSource;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:55
 * Copyright (c)   xdj
 */

public class MainProfileTest {

//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @Test
    public void test() {
//        printBeans(context);
        context.getEnvironment().setActiveProfiles("test","dev");
        context.register(MainConfigOfProfile.class);
        context.refresh();
        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }

    }

    private void printBeans(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
    }
}