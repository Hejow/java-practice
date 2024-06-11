package hejow.java.practice.livestudy.thread;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread thread1 = new NewThread();
        Thread thread2 = new NewThread();
        thread2.setPriority(7);

        System.out.println("상속받은 쓰레드 우선순위 : " + thread1.getPriority());
        System.out.println("설정한 쓰레드 우선순위 : " + thread2.getPriority());
    }
}
