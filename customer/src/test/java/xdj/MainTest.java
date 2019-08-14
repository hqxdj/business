package xdj;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xdj.config.MainConfig;
import xdj.config.MainConfig2;
import xdj.entity.Person;

import java.util.Map;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 14:44
 * Copyright (c)   xdj
 */

public class MainTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test4(){
//        printBeans(context);
        Object colorFactoryBean = context.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());

        Object FactoryBean = context.getBean("&colorFactoryBean");
        System.out.println(FactoryBean.getClass());
    }



    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        printBeans(context);
    }

    private void printBeans(AnnotationConfigApplicationContext context ) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String s : beanDefinitionNames){
            System.out.println(s);
        }
    }


    // 测试bean的作用域
    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("ioc容器初始化完成、、、、、");
        Object person = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person==person2);

    }
    // 测试bean的作用域
    @Test
    public void test3(){
        String property = context.getEnvironment().getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        Map<String, Person> beans = context.getBeansOfType(Person.class);
        for (String name : beanNamesForType){
            System.out.println(name);
        }
        System.out.println(beans);

    }
}
