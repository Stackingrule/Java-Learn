package threadcoreknowledge.sixstates;


/**
 * 描述：     展示线程的NEW、RUNNABLE、Terminated状态。即使是正在运行，也是Runnable状态，而不是Running。
 */
public class NewRunnableTerminated implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());

        // 打印 new
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印 Runnable。即使是正在运行，也是Runnable状态，而不是Running。
        System.out.println("*****************************************************");    //方便控制台观察
        System.out.println(thread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印 Terminated
        System.out.println("*****************************************************");    //方便控制台观察
        System.out.println(thread.getState());

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("i = "+ i);
        }
    }
}
