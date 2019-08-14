package xdj.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description: 自定义的过滤规则
 * @Date 2019/8/7 16:03
 * Copyright (c)   xdj
 */

public class MyTypeFilter implements TypeFilter {

    /**
     * 该类主要用于过滤包扫描中的类，在当前过滤器中所包含的信息
     *
     * @param metadataReader
     * @param metadataReaderFactory
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // metadataReader数据源读取器，可以读取当前正在被处理的类的所有信息
        // 获取当前类的资源，如URL等
        Resource resource = metadataReader.getResource();
        // 获取注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println("当前正在处理的类--->" + classMetadata.getClassName());
        if (classMetadata.getClassName().contains("main")){
            return true;
        }
        return false;
    }
}
