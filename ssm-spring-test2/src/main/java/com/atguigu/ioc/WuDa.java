package com.atguigu.ioc;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/6 18:07
 */
@Component
public class WuDa implements ISale{

    public void saleShaoBing() {
        System.out.println("目标操作:卖烧饼...");
    }


    public void saleYueBing() {
        System.out.println("目标操作:卖月饼...");
        throw new RuntimeException("月饼好像过期了!");
    }


    public Integer saleJianBing() {
        System.out.println("目标操作:卖煎饼...");
        return 99;
    }


    public void saleManTou() {
        System.out.println("目标操作:卖馒头...");
    }
}
