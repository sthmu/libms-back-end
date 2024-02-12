package org.lib.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConf {


    @Bean
    public ModelMapper makeModelMapperBean(){
        return new ModelMapper();
    }
}
