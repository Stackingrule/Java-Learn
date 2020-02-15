package com.mmall.concurrency.example.Singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@NotThreadSafe
public class SingletonExample4 {

    /**
     * 懒汉模式 -》双重同步锁代理模式
     */
    // 私有构造函数
    private SingletonExample4() {

    }

    // 单例对象
    private static SingletonExample4 instance = null;

    // 静态工厂方法
    public static SingletonExample4 getInstance() {
        if (instance == null) { // 双层检测机制
            synchronized (SingletonExample4.class) {    // 同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }

}
