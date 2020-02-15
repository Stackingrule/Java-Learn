package com.mmall.concurrency.example.Singleton;

import com.mmall.concurrency.annotations.Recommend;
import com.mmall.concurrency.annotations.ThreadSafe;

/**  枚举模式  **/
@ThreadSafe
@Recommend
public class SingletonExample7 {

   // 私有构造函数
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singletonExample7;

        Singleton() {
            singletonExample7 = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singletonExample7;
        }
    }
}
