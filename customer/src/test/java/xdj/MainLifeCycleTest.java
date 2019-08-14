package xdj;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xdj.config.MainConfigLifeCycle;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/8 9:55
 * Copyright (c)   xdj
 */

public class MainLifeCycleTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
    @Test
    public void test(){

        context.close();
    }
}
