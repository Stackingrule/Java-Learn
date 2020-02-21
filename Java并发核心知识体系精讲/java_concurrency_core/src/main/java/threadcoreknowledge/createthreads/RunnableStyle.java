package threadcoreknowledge.createthreads;

/**
 * <h1>用Runnable方式创建线程</h1>
 */
public class RunnableStyle implements Runnable {

    public static void main(String[] args) {

        Thread thread = new Thread(new RunnableStyle());
        thread.run();
    }

    @Override
    public void run() {

        System.out.println("用Runnable方法实现线程");
    }

}
