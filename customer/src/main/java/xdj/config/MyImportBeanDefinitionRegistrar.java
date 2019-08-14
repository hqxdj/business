package xdj.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import xdj.bean.RainBow;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:17
 * Copyright (c)   xdj
 */

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 配置类的注解信息
     * @param registry bean注册器
     *                 能够通过注册器获取bean，注册bean，移除bean
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean r = registry.containsBeanDefinition("xdj.bean.Red");
        boolean b = registry.containsBeanDefinition("xdj.bean.Blue");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
        if (r && b) {
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
