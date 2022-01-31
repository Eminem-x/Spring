package com.yuanhao.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Yuanhao
 */
@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("MyAspect.pointcut()")
    public void before() {
        System.out.println("pre...");
    }

    public void afterReturning() {
        System.out.println("after...");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("before...");
        Object proceed = pjp.proceed();
        System.out.println("behind...");
        return proceed;
    }

    @Pointcut("execution(* com.yuanhao.anno.*.*(..))")
    public void pointcut(){}
}


