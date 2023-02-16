package com.atguigu.ioc;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
public class WuDaAspect {
    @Before("execution(* *Bing(..))")
    public void song(){
        System.out.println("送大麦茶...");
    }
    @After("execution(* *Bing(..))")
    public void baiGei(){
        System.out.println("这波白给1000块...");
    }
}
