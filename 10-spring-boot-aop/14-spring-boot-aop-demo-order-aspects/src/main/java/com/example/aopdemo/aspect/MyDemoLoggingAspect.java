package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging

    //let's start with a @Before advice

    //2.apply pointcut declaration in this advice
    @Before("com.example.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    // add all class start with add
    //.. match on any number of arguments
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on method");
    }
}
