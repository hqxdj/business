package xdj.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 17:48
 * Copyright (c)   xdj
 */
@Component
public class Red implements ApplicationContextAware, EmbeddedValueResolverAware, BeanNameAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("解析器解析后的值${os.name}" + "#{20*18}");
        System.out.println(s);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名称是 "+name);
    }
}
