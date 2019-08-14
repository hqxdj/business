package xdj.main;

import xdj.config.MainConfig;
import xdj.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 11:25
 * Copyright (c)   xdj
 */

public class MainTest {
    public static void main(String[] args) {
        // 通过xml方式获取bean
//        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
//        Person person = (Person) context.getBean("person");
//        System.out.println(person);

//        通过注解方式获取
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = context.getBean(Person.class);
//        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
        System.out.println(bean);
    }
}
