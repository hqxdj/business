package xdj.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 17:13
 * Copyright (c)   xdj
 */

public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取bean注册器
        BeanDefinitionRegistry registry = context.getRegistry();
        // bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 当前类的类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 当前类的资源加载器
        ResourceLoader resourceLoader = context.getResourceLoader();
        // 获取当前应用运行的环境信息
        Environment environment = context.getEnvironment();
        if (environment.getProperty("os.name").contains("Windows")){
            return true;
        }

        return false;
    }
}
