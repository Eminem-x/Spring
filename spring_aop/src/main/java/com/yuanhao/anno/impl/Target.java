package com.yuanhao.anno.impl;

import com.yuanhao.anno.TargetInterface;
import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("Running...");
    }
}
