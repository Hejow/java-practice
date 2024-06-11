package hejow.java.practice.livestudy.thread;

public class ThreadTest {
    public static void main(String[] args) {
        runMultiThread();
    }
    public static void runMultiThread() {
        NewRunnable[] runnable = new NewRunnable[3];
        NewThread[] thread = new NewThread[3];

        for (int i = 0 ; i < 3 ; i++) {
            runnable[i] = new NewRunnable();
            thread[i] = new NewThread();

            new Thread(runnable[i]).start();
            thread[i].start();
        }

        System.out.println("RunMultiThread() ended");
    }
}
