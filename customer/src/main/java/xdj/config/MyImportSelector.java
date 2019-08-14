package xdj.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/7 17:59
 * Copyright (c)   xdj
 */

public class MyImportSelector implements ImportSelector {
    // 返回需要被注入到容器的类的全类名
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"xdj.bean.Blue","xdj.bean.Yellow"};
    }
}
