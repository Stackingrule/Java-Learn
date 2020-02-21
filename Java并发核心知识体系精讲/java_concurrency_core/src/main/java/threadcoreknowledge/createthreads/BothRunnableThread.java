package threadcoreknowledge.createthreads;

/**
 * <h1>同时使用两种方法</h1>
 */
public class BothRunnableThread {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("来自Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("来自Thread");
            }
        }.start();


    }
}
