package com.yuanhao.proxy.cglib;

/**
 * @author Yuanhao
 */
public class Advice {
    public void before() {
        System.out.println("pre...");
    }

    public void after() {
        System.out.println("after...");
    }
}
