package com.yuanhao.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Yuanhao
 */
public class MyAspect {
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
}
