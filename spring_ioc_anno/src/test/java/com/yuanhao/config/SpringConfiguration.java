package com.yuanhao.config;

import org.springframework.context.annotation.*;

//标志该类时Spring的核心配置类
@Configuration
@ComponentScan("com.yuanhao")
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
