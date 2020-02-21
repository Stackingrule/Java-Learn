package threadcoreknowledge.createthreads;

/**
 * <h1>用Thread方式创建线程</h1>
 */
public class ThreadStyle extends Thread{

    public static void main(String[] args) {

        new ThreadStyle().start();
    }

    @Override
    public void run() {
        System.out.println("用Thread方法实现线程");
    }
}
