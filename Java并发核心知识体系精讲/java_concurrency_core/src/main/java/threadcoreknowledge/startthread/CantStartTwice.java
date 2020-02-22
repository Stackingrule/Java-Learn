package threadcoreknowledge.startthread;

/**
 * <h1>演示不能两次调用start方法</h1>
 */
public class CantStartTwice {

    public static void main(String[] args) {

        Thread thread = new Thread();
        thread.start();
        thread.start();
    }

}
