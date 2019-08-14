package xdj.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 10:17
 * Copyright (c)   xdj
 */
@Component
public class Dog implements ApplicationContextAware {

    ApplicationContext applicationContext;
    public Dog() {
        System.out.println("Dog constructor..");
    }

    @PostConstruct
    public void init(){
        System.out.println("Dog PostConstruct..");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog preDestroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }
}
