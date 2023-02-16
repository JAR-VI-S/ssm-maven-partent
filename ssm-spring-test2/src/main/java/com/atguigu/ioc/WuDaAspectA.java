package com.atguigu.ioc;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description:
 * 该版本可以重用pointCut, 通过全类名.方法名使用
 * @author 程翔宇
 * @date 2023/2/6 19:12
 */
//环绕增强
@Aspect
@Component
@Order(5)
public class WuDaAspectA {
    @Before("com.atguigu.ioc.MyPiontCut.mypoint()")
    public void baiGei(){
        System.out.println("A切面 前置操作:送大麦茶...");
    }
    @After("com.atguigu.ioc.MyPiontCut.mypoint()")
    public void baiGei2(){
        System.out.println("A切面 后置操作:这波白给666...");
    }
    @AfterReturning(value = "com.atguigu.ioc.MyPiontCut.mypoint()",returning = "number")
    public void baiGei3(Integer number){
        System.out.println("A切面 返回通知：目标返回值是"+number);
    }
}
