package com.yuanhao.proxy.jdk;

import com.yuanhao.proxy.jdk.impl.Target;

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

        // 动态生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                // 目标对象类加载
                target.getClass().getClassLoader(),
                // 目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 前置增强
                        advice.before();
                        // 执行目标方法
                        Object invoke = method.invoke(target, args);
                        // 后置增强
                        advice.after();
                        return invoke;
                    }
                }
        );

        //调用代理对象的方法
        proxy.save();
    }
}
