package com.nyist.config;

import com.nyist.utils.FileTypeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //设置文件虚拟路径映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("yun/file/**").addResourceLocations("file:D:\\stroage\\yunfile\\files\\");
    }

    //设置视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 访问根路径或/index.html时跳转到index界面
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }


    //将使用的工具类注册到容器中（也可通过注解注册）
    @Bean
    public FileTypeUtils fileTypeUtils(){
        return new FileTypeUtils();
    }

}
