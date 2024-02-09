package com.example.demo.configuration;


import com.example.demo.aspects.LoggingAspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example.demo.service")
@EnableAspectJAutoProxy
public class ProjectConfiguration {


    //public LoggingAspect aspect(){return new LoggingAspect();}




}
