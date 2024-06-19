package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging

    //1.create a pointcut declaration so that we will create once and use in multiple advices
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){ }

    //let's start with a @Before advice

    //2.apply pointcut declaration in this advice
    @Before("forDaoPackage()")
    // add all class start with add
    //.. match on any number of arguments
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on method");
    }
}
