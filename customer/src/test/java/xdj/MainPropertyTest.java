package xdj;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xdj.config.MainConfigLifeCycle;
import xdj.config.MainConfigOfPropertyValue;
import xdj.entity.Person;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:55
 * Copyright (c)   xdj
 */

public class MainPropertyTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
    @Test
    public void test(){
        printBeans(context);
        Person person = (Person) context.getBean("person");
        String property = context.getEnvironment().getProperty("person.nickName");
        System.out.println(person);
        System.out.println(property);
    }

    private void printBeans(AnnotationConfigApplicationContext context ) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String s : beanDefinitionNames){
            System.out.println(s);
        }
    }
}
