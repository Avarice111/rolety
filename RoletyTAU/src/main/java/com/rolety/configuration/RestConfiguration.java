package com.rolety.configuration;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan({"com.rolety.roletycrud"})
public class RestConfiguration extends WebMvcConfigureAdapter
{
    @Override
    public void configureMessageConferters(List<HttpMessageConferter<?>> messageConverters)
    {
        super.configureMessageConferters(messageConverters);
    }
}