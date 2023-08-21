package Live_Study.Thread;

public class threadTest {
    public static void main(String[] args) {
        runMultiThread();
    }
    public static void runMultiThread() {
        newRunnable[] runnable = new newRunnable[3];
        newThread[] thread = new newThread[3];

        for (int i = 0 ; i < 3 ; i++) {
            runnable[i] = new newRunnable();
            thread[i] = new newThread();

            new Thread(runnable[i]).start();
            thread[i].start();
        }

        System.out.println("RunMultiThread() ended");
    }
}
