package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " +method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingAdvice(
        JoinPoint theJoinPoint, Throwable theExc){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " +method);

        //log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);

    }

    //add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " +method);

        //print out the results of the method call
        System.out.println("\n=====> result is:" + result);

        //let's a post-process the data ... let's modify it :-)

        //convert the account name to uppercase
        convertAccountNameToUpperCase(result);

        System.out.println("\n=====> result is:" + result);

    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        //loop through accounts
        for(Account tempAccount : result){

            //get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            //update the name on the account
            tempAccount.setName(theUpperName);
        }

    }


    //this is where we add all of our related advices for logging

    //let's start with a @Before advice

    //2.apply pointcut declaration in this advice
    @Before("com.example.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    // add all class start with add
    //.. match on any number of arguments
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n===>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method:" +methodSignature);

        //display method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){

                //downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("account name: " +theAccount.getName());
                System.out.println("account level: " +theAccount.getLevel());

            }
        }

    }
}
