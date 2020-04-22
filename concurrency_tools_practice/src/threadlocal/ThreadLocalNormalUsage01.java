package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO 30个线程
public class ThreadLocalNormalUsage01 {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 30; ++i) {
            int finalI = i + 100;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage01().date(finalI);
                    System.out.println(date);
                }
            }).start();
            Thread.sleep(1000);
        }
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
