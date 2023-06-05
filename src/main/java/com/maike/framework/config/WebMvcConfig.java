package com.maike.framework.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.maike.common.exception.ServiceException;
import com.maike.common.result.AjaxResult;
import com.maike.common.result.ResultStatusEnum;
import com.maike.framework.web.MyErrorPageRegister;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Spring MVC 配置
 */
//@Configuration
//@EnableWebMvc
@Component
// 方法一：实现WebMvcConfigurer接口
public class WebMvcConfig implements WebMvcConfigurer {
//方法二：继承WebMvcConfigurationSupport类
//public class MVCConfiguration extends WebMvcConfigurationSupport {
    //@Autowired
    //AdminLoginInterceptor adminLoginInterceptor;
    /**
     * 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/backManage","/backManage/**").excludePathPatterns("/backlogin");
        //swagger白名单
//        .excludePathPatterns("/webjars/**")
//        .excludePathPatterns("/swagger-ui.html")
//        .excludePathPatterns("/v2/**")
//        .excludePathPatterns("/swagger-resources/**");
        //registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/backManage/**").excludePathPatterns("/backlogin","/**");
        //WebMvcConfigurer.super.addInterceptors(registry);
    }
//	@Bean
//	public AdminLoginInterceptor adminLoginInterceptor() {
//		return new AdminLoginInterceptor();
//	}
//	/**
//	 * 添加类型转换器和格式化器
//	 *
//	 * @param registry
//	 */
//	@Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
//    }

//	@Bean
//	public FilterRegistrationBean someFilterRegistration() {
//		//新建过滤器注册类
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		// 添加我们写好的过滤器
//		registration.setFilter( new MyWebFilter());
//		registration.setName("myWebFilter");//过滤器名称
//		// 设置过滤器的URL模式
//		registration.addUrlPatterns("/*");
//		registration.setEnabled(false);
//		return registration;
//	}

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false);
//        //WebMvcConfigurer.super.configurePathMatch(configurer);
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler是指你想在url请求的路径
        //addResourceLocations是图片存放的真实路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/template/**").addResourceLocations("classpath:/template/");
        // 映射图片保存地址
        registry.addResourceHandler("/uploadFile/userPic/**")
                .addResourceLocations("file:/Volumes/MacFile/myWorkSpace/SpringBootTestFile/aboutUs/pic/");
        //registry.addResourceHandler("/static/**").addResourceLocations("/templates/**");
        //Swagger-ui的路径映射
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/*/*/*").addResourceLocations("classpath:/META-INF/resources/webjars/");
//		registry.addResourceHandler("/webjars/*/*").addResourceLocations("classpath:/META-INF/resources/webjars/");
        //super.addResourceHandlers(registry);
    }

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24)
                .allowedHeaders("*");
        //super.addCorsMappings(registry);
    }

    //	@Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//        registry.addViewController("/").setViewName("forward:/");
//
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//
//        //WebMvcConfigurer.super.addViewControllers(registry);
//
//    }
    @Bean
    public ErrorPageRegistrar errorPageRegistrar() {
        return new MyErrorPageRegister();
    }
}
