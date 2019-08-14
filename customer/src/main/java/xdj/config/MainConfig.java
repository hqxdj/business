package xdj.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import xdj.controller.BookController;
import xdj.entity.Person;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 14:06
 * Copyright (c)   xdj
 */

@ComponentScans(value = {
        @ComponentScan(basePackages = "xdj",
                includeFilters = {
                        @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
//@Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDao.class}),
//@Filter(type = FilterType.CUSTOM, classes = {MyFilter.class})
                }, useDefaultFilters = false)})
// Filter[] excludeFilters() 不含过滤器
// Filter[] includeFilters() 只包含 要先设置默认过滤器为false
// FilterType.ASSIGNABLE_TYPE 指定具体的类
//  FilterType.CUSTOM 用户自定义的的
// 等价于xml
//@Configuration // 当时用了@componentScan则该类也成为了一个配置类
public class MainConfig {

    @Bean("person")  // 相当于配置文件的额bean标签，方法名相当于id，返回值为class
    public Person person() {
        return new Person(18, "lisi");
    }
}
