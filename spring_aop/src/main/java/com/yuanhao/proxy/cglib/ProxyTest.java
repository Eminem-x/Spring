package com.yuanhao.proxy.cglib;

import com.yuanhao.proxy.jdk.TargetInterface;
import com.yuanhao.proxy.jdk.impl.Target;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yuanhao
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 目标对象
        Target target = new Target();

        // 增强对象
        Advice advice = new Advice();

        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类目标
        enhancer.setSuperclass(Target.class);
        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, objects);
                advice.after();
                return invoke;
            }
        });
        // 创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
