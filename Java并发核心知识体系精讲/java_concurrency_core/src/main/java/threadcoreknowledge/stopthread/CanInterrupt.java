package threadcoreknowledge.stopthread;

/**
 * 描述：如果 while 里面放try/cantch 会导致中断失效
 */
public class CanInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = ()-> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }

}
