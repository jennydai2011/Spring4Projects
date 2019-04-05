package com.jdai.diveIntoBoot.annotation;

import com.jdai.diveIntoBoot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata){
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
