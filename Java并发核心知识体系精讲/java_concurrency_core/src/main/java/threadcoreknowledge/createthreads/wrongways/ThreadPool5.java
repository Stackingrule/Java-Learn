package threadcoreknowledge.createthreads.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h1>线程池创建线程方法</h1>
 */
public class ThreadPool5 {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Task() {});
        }

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        }
    }

}
