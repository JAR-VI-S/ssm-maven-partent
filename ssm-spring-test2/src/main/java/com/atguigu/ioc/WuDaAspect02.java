package com.atguigu.ioc;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

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
public class WuDaAspect02 {
    @Before("execution(* *Bing(..))")
    public void song() {
        System.out.println("前置操作:送大麦茶...");
    }

    @After("execution(* *Bing(..))")
    public void baiGei() {
        System.out.println("后置操作:这波白给1000块...");
    }

    @AfterReturning("execution(* *Bing(..))")
    public void song2() {
        System.out.println("返回通知:afterReturning........");
    }

    @AfterThrowing("execution(* *Bing(..))")
    public void song3(){
            System.out.println("异常通知:afterThrowing......");
    }
}
