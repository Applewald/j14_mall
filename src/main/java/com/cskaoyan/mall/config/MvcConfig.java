package com.cskaoyan.mall.config;

import com.cskaoyan.mall.converter.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;

/**
 * author : summer
 * date 2019/7/4 14:33
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /*视图解析器*/
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        return internalResourceViewResolver;
    }

    /*处理器（数据转换器）*/
    @Autowired
    ConfigurableConversionService configurableConversionService;
    @PostConstruct
    public void addConverter() {
        /*模板，将自己定义的转换器类放在后面即可*/
        configurableConversionService.addConverter(new DateConverter());
    }

    @Bean
    @Primary
    public ConfigurableConversionService configurableConversionService() {
        return configurableConversionService;
    }

    /*拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*模板，自己添加的拦截器放在后面即可*/
        //registry.addInterceptor(new)
    }
}
