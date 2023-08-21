package Live_Study.Thread;

public class threadPriority {
    public static void main(String[] args) {
        Thread thread1 = new newThread();
        Thread thread2 = new newThread();
        thread2.setPriority(7);

        System.out.println("상속받은 쓰레드 우선순위 : " + thread1.getPriority());
        System.out.println("설정한 쓰레드 우선순위 : " + thread2.getPriority());
    }
}
