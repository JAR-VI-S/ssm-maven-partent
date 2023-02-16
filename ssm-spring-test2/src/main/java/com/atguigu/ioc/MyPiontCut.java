package com.atguigu.ioc;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/6 20:46
 */
@Component
public class MyPiontCut {
@Pointcut("execution(* *Bing(..))")
    public void mypoint(){}
}
