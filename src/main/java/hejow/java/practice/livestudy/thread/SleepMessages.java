package hejow.java.practice.livestudy.thread;

public class SleepMessages {
    public static void main(String[] args) throws InterruptedException {
        String livingTips[] = {
                "1+1은 2이다.",
                "문희조는 잘생겼다.",
                "Hejow는 최고의 BE Developer다."
        };

        for (int i = 0 ; i < livingTips.length ; i++) {
            // 2초간 정지
            Thread.sleep(2000);
            // 메세지 출력
            System.out.println(livingTips[i]);
        }

    }
}
