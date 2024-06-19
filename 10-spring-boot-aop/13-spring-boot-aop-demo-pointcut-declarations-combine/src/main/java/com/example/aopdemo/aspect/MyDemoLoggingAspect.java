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

    //create a pointcut for getter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    public void getter(){ }

    //create a pointcut for getter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setter(){ }

    //2. combine pointcut declarations
    //create a pointcut:include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){ }


    //let's start with a @Before advice

    //2.apply pointcut declaration in this advice
    @Before("forDaoPackageNoGetterSetter()")
    // add all class start with add
    //.. match on any number of arguments
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n===>>> Performing API analytics");
    }

}
