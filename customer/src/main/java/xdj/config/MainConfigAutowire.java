package xdj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import xdj.bean.Car;
import xdj.bean.Color;
import xdj.dao.BookDao;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 15:24
 * Copyright (c)   xdj
 */
@Configuration
@ComponentScan(value = {"xdj.controller","xdj.service","xdj.dao","xdj.bean"})
public class MainConfigAutowire {

    /**
     * 自动装配：
     *          spring利用依赖注入（DI），完成IOC容器各个组件的依赖关系赋值
     * 1）@Autowired:自动注入
     *      1）、默认优先按照类型去容器找对用的组件：context.getBean(BookDao.class)
     *      2）、如果找到多个相同类型的组件，再将组建的名称作为id去容器找
     *              context.getBean("bookDao")
     *      3）、@Qualifier（"bookDao"）,使用@Qualifier指定需要需要装配的逐渐id，而不使用属性名
     *      4）、自动装配默认一定要将属性赋值好，如果没有赋值则报错
     *          可以使用@Autowired（required=false）
     *      5）、@Primary，让spring装配的时候默认使用首选的bean
     *          也可以使用@Qualifier指定需要装配的bean
     * 基于javaJSR250和JSR330规范
     * 2)   @Resource：JSR250
     *              同样能实现@Autowired的注入功能，默认是按照组件名称来注入
     *              不支持@Primary功能，也不支持@Qualifier
     *      @Inject
     *              功能和@Autowired相同，也不支持required=false
     *              支持@Primary功能
     * 注意：@Autowired为spring的注解，@Resource和@Inject为java注解
     * AutowiredAnnotationBeanPostProcessor 进行注解功能的额解析
     *
     *  2、@Autowired：标注在constructor，method，parameter，field 都是从容器中获取参数
     *           1）、参数位置：@Bean+参数，参数从容器获取（Autowired可以省略）
     *           2）、构造器位置：默认是调用无惨构造器进行初始化，如果只含有一个有参构造器（Autowired可以省略），
     *           则调用该构造器，参数从容器中获取
     *           3）、方法位置
     *  3、自定义组件使用spring容器的底层组件方式，(ApplicationContext,BeanFactory,XXX)
     *      自定义组件实现XXXAware,在注入组件是会调用相应的方法为组件注入值
     *      将值注入到组件的同过XXXProcessor来是实现
     *      ApplicationContextAware==》ApplicationContextAwareProcessor
     */

    @Bean("bookDao2")
    @Primary
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
