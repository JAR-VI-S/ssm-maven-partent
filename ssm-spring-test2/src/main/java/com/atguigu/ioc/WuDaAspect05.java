package com.atguigu.ioc;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Description:
 * 该版本可以重用pointCut, 通过全类名.方法名使用
 * @author 程翔宇
 * @date 2023/2/6 19:12
 */



//环绕增强
//@Aspect
@Component
public class WuDaAspect05 {
    @Around("com.atguigu.ioc.MyPiontCut.mypoint()")
    public void song(ProceedingJoinPoint joinPoint){
        try {
            //此处相当于@Before - 前置增强
            System.out.println("before...");
            Object returnObj = joinPoint.proceed(joinPoint.getArgs());
            //此处相当于@AfterReturning - 后置返回增强
            System.out.println("after returning...");
        } catch (Throwable e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
            //此处相当于@AfterThrowing - 抛异常时增强
            System.out.println("after throwing...");
        }finally {
            //此处相当于@After - 后置增强
            System.out.println("after...");
        }
    }
}
