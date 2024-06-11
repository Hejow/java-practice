package hejow.java.practice.livestudy.thread;

public class ThreadCallStack {
    public static void main(String[] ars) {
        Thread thread = new ThreadOne();
        thread.start();
    }
}

class ThreadOne extends Thread {
    @Override
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
