package hejow.java.practice.etc.async;

import java.util.concurrent.CompletableFuture;

public class AsyncFactory {
    private AsyncFactory() {
    }

    public static void runAsync() {
        CompletableFuture.runAsync(() ->
                System.out.println("Thread : " + Thread.currentThread().getName())
        );

        System.out.println("Thread : " + Thread.currentThread().getName());
    }

    public static void supplyAsync() {
        CompletableFuture.supplyAsync(() ->
                "Thread : " + Thread.currentThread().getName()
        ).thenAccept(System.out::println);

        System.out.println("Thread : " + Thread.currentThread().getName());
    }
}
