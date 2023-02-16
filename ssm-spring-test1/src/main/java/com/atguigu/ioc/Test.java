package com.atguigu.ioc;

import java.lang.reflect.Proxy;

/**
 * Description:
 * 使用jdk动态代理实现
 * 优点是 创建对象效率较高,但方法调用效率较低,适合多例场景
 * @author 程翔宇
 * @date 2023/2/6 18:22
 */
public class Test {
    public static void main(String[] args) {
        ISale target = new WuDa();
        WuDaInvocationHandler handler = new WuDaInvocationHandler(target);
        //newProxyInstance:创建代理实例对象
        //三个参数：
        //① 目标类的类加载器。 ② 目标类的父接口  ③ handler
        //只有拥有了上面三个"原料"，我们Proxy才能创建出代理对象
        ISale proxy = (ISale) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.saleShoBing();

        }
}
