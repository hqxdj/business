package xdj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xdj.entity.Person;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 11:26
 * Copyright (c)   xdj
 */
// 读取外部的配置文件中的k/v值到运行环境中，通过${k}的方式获取V的值
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValue {

    /**
     * 给属性赋值
     * @Value   直接赋值("")
     *          spEL表达式 #{}
     *          配置文件读取 ${}（运行环境变量）
     *
     */

    @Bean
    public Person person(){
        return new Person();
    }


}
