package com.mmall.concurrency.example.Singleton;

import com.mmall.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class SingletonExample5 {

    /**
     * 懒汉模式 -》双重同步锁代理模式
     */
    // 私有构造函数
    private SingletonExample5() {

    }

    // volatile + 双重检测机制 -> 禁止指令重排
    // 单例对象
    private volatile static SingletonExample5 instance = null;

    // 静态工厂方法
    public static SingletonExample5 getInstance() {
        if (instance == null) { // 双层检测机制
            synchronized (SingletonExample5.class) {    // 同步锁
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }

}
