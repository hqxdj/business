package xdj.config;

import org.springframework.context.annotation.*;
import xdj.bean.Color;
import xdj.bean.ColorFactoryBean;
import xdj.bean.Red;
import xdj.condition.LinuxCondition;
import xdj.condition.WindowsCondition;
import xdj.entity.Person;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 16:34
 * Copyright (c)   xdj
 */
@Configuration
// 如果conditional加载类上，则表示当前配置类中的所有bean只有满足条件才会被加载
//@Conditional({WindowsCondition.class})
@Import({Color.class, Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    /**
     *    ConfigurableBeanFactory#SCOPE_PROTOTYPE 多例
     * 	  ConfigurableBeanFactory#SCOPE_SINGLETON 单例
     * 	  org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
     * 	  org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
     *
     * @scope 作用域
     *     String SCOPE_SINGLETON = "singleton"; ioc容器初始化时会创建对象放到容器中
     *     String SCOPE_PROTOTYPE = "prototype"; ioc容器初始化时不会创建对象放到容器中，每次获取对象时进行初始化
     *
     * lazy 懒加载针对单实例
     */

//    @Scope("prototype")
    @Lazy
    @Bean
    public Person person(){
        System.out.println("往容器中添加实例。。。。");
        return new Person(18,"wan");
    }

    /**
     * conditional 匹配条件，则注册该组件
     */
    @Bean
    @Conditional({WindowsCondition.class})
    public Person bill(){
        return new Person(66,"比尔");
    }

    @Bean
    @Conditional({LinuxCondition.class})
    public Person linux(){
        return new Person(46,"linus");
    }

    /**
     * 给容器中注册bean的方式
     * 1、通过包扫描+组件注解（@Controller、@Service、@Component、@Repository）
     * 2、@Bean（用于导入第三方包）
     * 3、@Import（快速导入一个组件）
     *      1、@Import（要导入到容器的组件）,默认为该类的全类名
     *      2、@ImportSelector 导入选择器 （导入的为全类名）--- spring常用
     *      3、@ImportBeanDefinitionRegistrar 通过beanDefinition注册器导入bean 可以其定义bean名称
     *      4、通过FactoryBean创建实例
     *              默认返回的的是FactoryBean中geObject返回的bean
     *              如果要获取FactoryBean本身则需要在id前加上 &colorFactoryBean
     *
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
