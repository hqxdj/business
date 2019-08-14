package xdj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xdj.aop.LogAspects;
import xdj.aop.MathCalculator;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description: aop
 * @Date 2019/8/12 14:04
 * Copyright (c)   xdj
 *
 * AOP：【动态代理】
 *      程序运行期间动态的将某段代码切入到指定方法指定的位置运行
 *  1)、导入依赖aspect
 *  2）、业务逻辑类
 *  3)、定义一个切面类（LogAspects）类，切面内的方法要动态感知MathCalculator.div运行到哪了
 *      前置
 *      后置
 *      返回
 *      异常
 *      环绕
 *  切点表达式的常用集中写法
 * 1、execution(* xdj.aop.MathCalculator.*(..))
 * 2、within(xdj.aop.MathCalculator) 或者 within(xdj.aop.*)不包括子包中的类 或者 within(xdj.aop..*)
 * 4）、给切面方法添加切点pointcut
 * 5）、将切面和业务罗积累都加到容器中
 * 6）、且面类中添加@Aspect注解，告诉容器为切面
 * 7）、配置类中添加@EnableAspectJAutoProxy，启动切面动态代理
 *
 * Aop原理：[看给容器注册了什么组件，这些组件完成了什么功能]
 *          @EnableAspectJAutoProxy
 *          @Import(AspectJAutoProxyRegistrar.class)
 *          ImportBeanDefinitionRegistrar->bean注册器，给容器注册组件
 *          internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *          给容器注册一个bean名称叫internalAutoProxyCreator
 * 2.AnnotationAwareAspectJAutoProxyCreator
 *      ->AspectJAwareAdvisorAutoProxyCreator
 *          ->AbstractAdvisorAutoProxyCreator
 *              ->AbstractAutoProxyCreator
 *              implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *              后置处理器，beanFactory
 *
 *AbstractAutoProxyCreator.setBeanFactory()
 * AbstractAutoProxyCreator 后置处理器的逻辑
 *
 * AbstractAdvisorAutoProxyCreator.setBeanFactory()->initBeanFactory()
 *
 * AspectJAwareAdvisorAutoProxyCreator
 *
 * AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 *
 * 流程：
 *      1.传入配置，启动ioc容器
 *      2.注册配置类，调用refresh（）方法刷新容器 ->先创建beanFactory
 *      3.registerBeanPostProcessors(beanFactory);注册bean的后置拦截器，方便拦截bean的创建
 *          1）、先获取ioc容器已经定义了需要创建的beanPostProcessor
 *          2）、给容器中加其他需要注册的beanPostProcessor
 *          3）、优先注册实现了PriorityOrdered接口的beanPostProcessor
 *          4）、再注册实现了order接口的beanPostProcessor
 *          5）、最后注册普通的beanPostProcessor
 *          6）、注册beanPostProcessor，实际就是创建beanPostProcessor对象，保存到容器中
 *              创建internalAutoProxyCreator的BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】
 *              1）、创建的bean的实例
 *              2）、populateBean(beanName, mbd, instanceWrapper)给bean中的属性赋值
 *              3）、      initializeBean：初始化bean
 *                     1）、invokeAwareMethods；处理Aware接口的回调
 *                     2）、applyBeanPostProcessorsBeforeInitialization调用后置处理器的postProcessBeforeInitialization
 *                     3）、invokeInitMethods调用bean的初始化方法
 *                     4）、applyBeanPostProcessorsAfterInitialization调用后置处理器的postProcessAfterInitialization
 *              4）、BeanPostProcessor创建成功
 *         7）、把BeanPostProcessor注册到容器中
 *              beanFactory.addBeanPostProcessor()
 *
 *
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {

    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
