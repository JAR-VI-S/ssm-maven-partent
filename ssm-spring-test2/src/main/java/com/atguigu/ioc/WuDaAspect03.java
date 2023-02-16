package com.atguigu.ioc;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/6 19:12
 */



/*@Component : 表明当前切面类必须纳入IOC容器管理
@Aspect : 表明当前是一个切面类*/
//演示增强执行的顺序问题
//从spring5.3.x开始，执行顺序是：
/*
@Before
@AfterReturning 或者 @AfterThrowing
@After*/
//@Aspect
@Component
public class WuDaAspect03 {
    @Before("execution(* *Bing(..))")
    //1.获取连接点的信息
    public void song(JoinPoint joinPoint) {
        //joinPoint称之为连接点
        //1.获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        System.out.println(signature.getDeclaringType());
        System.out.println(signature.getDeclaringType().getName());
        System.out.println("前置操作:送大麦茶...");
    }
    //2.获取目标方法的返回值信息
    @AfterReturning(value = "execution(* *Bing(..))",returning = "number")
    public void song2(Integer number){
        System.out.println("返回通知：目标返回值是"+number);
    }
//    3.获取异常信息
    @AfterThrowing(value = "execution(* *Bing(..))",throwing = "throwSomething")
    public void song3(Throwable throwSomething){
        System.out.println("异常通知:"+throwSomething.getMessage());
        System.out.println("小问题,吃不死的");
    }

    @After("execution(* *Bing(..))")
    public void baiGei() {
        System.out.println("后置操作:这波白给1000块...");
    }
/*

    @AfterReturning("execution(* *Bing(..))")
    public void song2() {
        System.out.println("返回通知:afterReturning........");
    }

    @AfterThrowing("execution(* *Bing(..))")
    public void song3(){
            System.out.println("异常通知:afterThrowing......");
    }*/
}
