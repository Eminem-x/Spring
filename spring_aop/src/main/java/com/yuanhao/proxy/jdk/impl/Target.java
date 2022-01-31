package com.yuanhao.proxy.jdk.impl;

import com.yuanhao.proxy.jdk.TargetInterface;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("Running...");
    }
}
