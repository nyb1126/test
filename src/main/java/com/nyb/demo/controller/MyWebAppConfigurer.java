package com.nyb.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 17:55 2020/9/14
 * @Modified By:
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/上传文件/**").addResourceLocations("file:D:/上传文件/");
    }
}
