package xdj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import xdj.bean.Car;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:50
 * Copyright (c)   xdj
 */

@Configuration
@ComponentScan("xdj.bean")
public class MainConfigLifeCycle {

    /**
     *  bean生命周期 创建--初始化--销毁
     *
     *  初始化：
     *      对象创建好，赋值好，在调用初始化方法
     *  销毁：
     *      单例：由ioc容器统一管理实例的创建和销毁
     *      多例：只负责实例的创建和初始化，不负责销毁
     *
     * for (BeanPostProcessor processor : getBeanPostProcessors()) {
     * 			Object current = processor.postProcessBeforeInitialization(result, beanName);
     * 			if (current == null) {
     * 				return result;
     *                        }
     * 			result = current;* 		}
     * 		循环遍历容器的BeanPostProcessor执行	applyBeanPostProcessorsBeforeInitialization方法
     * 	之道返回null退出循环
     *
     *  BeanPostProcessor的工作原理
     *  populateBean(beanName, mbd, instanceWrapper)对bean进行属性赋值（setter）
     *  调用initial方法
     *  initializeBean(beanName, exposedObject, mbd){
     *      wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
     *      invokeInitMethods(beanName, wrappedBean, mbd); 初始化方法
     *      wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
     *  }
     *
     * 1、@Bean 中指定初始化方法和销毁方法
     * 2、通过bean
     *      实现InitializingBean中的afterPropertiesSet方法来实现初始化
     *      通过实现disposeAble中的destroy方法来实现销毁bean
     * 3、 通过PSR250 1. @PostConstruct 在bean创建完成，并赋值后，进行初始化工作
     *               2. @PreDestroy 在容器销毁的时候执行
     * 4、 通过BeanPostProcessor的
     *                      1.postProcessBeforeInitialization bean初始化之前调用
     *                      2.postProcessAfterInitialization  bean初始化之后调用
     * spring 中有许多postProcessor如Autowire，@Async等
     *
     */

//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
