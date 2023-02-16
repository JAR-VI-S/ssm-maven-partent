package com.atguigu.ioc;

/**
 * Description:
 *
 * @author 程翔宇
 * @date 2023/2/6 18:07
 */
public class WuDa implements ISale{

    @Override
    public void saleShoBing() {
        System.out.println("卖烧饼...");
    }

    @Override
    public void saleYueBing() {
        System.out.println("卖月饼...");
    }

    @Override
    public void saleJianBing() {
        System.out.println("卖煎饼...");
    }

    @Override
    public void saleManTou() {
        System.out.println("卖馒头...");
    }
}
