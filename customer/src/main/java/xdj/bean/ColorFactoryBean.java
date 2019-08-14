package xdj.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:34
 * Copyright (c)   xdj
 */

public class ColorFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        System.out.println("获取ColorBean。。。");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
