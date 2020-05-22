package collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {


    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        Interviwer interviwer = new Interviwer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(interviwer).start();
        new Thread(consumer).start();
    }
}


class Interviwer implements Runnable {
    BlockingQueue<String> queue;
    public Interviwer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("10个候选人都来了");
        for (int i = 0; i < 10; i++) {
            String candidate = "Candidate" + i;
            try {
                queue.put(candidate);
                System.out.println("安排好了" + candidate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put("stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    BlockingQueue<String> queue;
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg;

        try {
            msg = queue.take();
            while (!(msg = queue.take()).equals("stop")) {
                System.out.println(msg + "到了");

            }
            System.out.println("所有候选人都结束了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}