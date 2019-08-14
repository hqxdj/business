package xdj.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description: profile运用
 * @Date 2019/8/12 10:07
 * Copyright (c)   xdj
 *
 * spring 提供了可以根据当前环境动态的切换和激活一系列组件的功能
 *
 * @profile 指定组件在哪个环境生效，不指定，则在任何环境都能生效
 *
 * 1）、加了profile的bean，只有当前环境被激活是才会被加载到容器中，默认是default
 * 2）、加载配置类上，只有指定的环境被激活，相应的组件才会被加载到容器中
 * 3）、没有环境表示的bean，在任何环境都会被注入到容器中
 *
 * 设置相应环境的方法
 * 1）、通过设置启动参数的方式—Dspring.profiles.active=test
 * 2)、 通过代码的方式，context.getEnvironment().setActiveProfiles("test","dev");
 *                     context.register(MainConfigOfProfile.class);
 *                     context.refresh();
 *
 */
@PropertySource("classpath:/person.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    private String driverClass;

    @Profile("test")
    @Bean("dataSourceTest")
    public DataSource dataSourceTest(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc.mysql://localhost:3306/dbgirl");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean("dataSourceDev")
    public DataSource dataSourceDev(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc.mysql://localhost:3306/example");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Profile("pro")
    @Bean("dataSourcePro")
    public DataSource dataSourcePro(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc.mysql://localhost:3306/imooc_learning");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        driverClass = resolver.resolveStringValue("com.mysql.jdbc.Driver");
    }
}
