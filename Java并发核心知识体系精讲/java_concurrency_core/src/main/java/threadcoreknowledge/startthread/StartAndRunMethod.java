package threadcoreknowledge.startthread;

public class StartAndRunMethod {

    public static void main(String[] args) {

        // 1.run 方法
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        // 2.start 方法
        new Thread(runnable).start();
    }

}
