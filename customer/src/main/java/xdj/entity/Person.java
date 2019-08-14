package xdj.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 11:14
 * Copyright (c)   xdj
 */
@Data
public class Person {
    /**
     * 给属性赋值
     * @Value   直接复制("")
     *          spEL表达式 #{}
     *          配置文件读取 ${}（运行环境变量）
     *
     */

    @Value("#{20-2}")
    private Integer age;
    @Value("zs")
    private String name;

    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
}
