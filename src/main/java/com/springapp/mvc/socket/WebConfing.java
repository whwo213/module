package com.springapp.mvc.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;import java.lang.Override;

/**
 * Created by young on 2015-09-03.
 */
@Configuration
@EnableWebMvc
public class WebConfing extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
