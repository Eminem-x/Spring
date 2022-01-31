package com.yuanhao.aop.impl;

import com.yuanhao.aop.TargetInterface;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("Running...");
    }
}
