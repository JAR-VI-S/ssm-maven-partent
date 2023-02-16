package com.atguigu.ioc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/6 18:12
 */
public class WuDaInvocationHandler implements InvocationHandler {
    private ISale iSale;

    public WuDaInvocationHandler(ISale iSale){
        this.iSale = iSale;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if (name.endsWith("Bing")) {
            song();
        }
        return method.invoke(iSale,args);
    }

    private void song() {
        System.out.println("送大麦茶....");
    }
}
