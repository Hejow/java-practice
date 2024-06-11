package hejow.java.practice.etc.functionalInterface;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws Exception {
        // Runnable
        Runnable runnable = () -> System.out.println("this is runnable");
        runnable.run();

        // Supplier
        Supplier<String> helloSupplier = () -> "Hello World";
        String hello = helloSupplier.get();
        System.out.println("hello = " + hello);

        // Consumer
        Consumer<String> consumer = text -> System.out.println("Hello " + text);
        Consumer<String> consumer2 = text -> System.out.println("Hello John ");
        String world = "World";
        consumer.accept(world);
        consumer.andThen(consumer2).accept("hejow");

        // Function
        Function<Integer, Integer> timesTwo = number -> number * 2;
        int result = timesTwo.apply(3);

        Function<Integer, Integer> addThree = number -> number + 3;
        Function<Integer, Integer> addThenMultiply = timesTwo.compose(addThree);

        Integer result2 = addThenMultiply.apply(3);

        // Predicate
        Predicate<Integer> isBiggerThanTen = number -> number > 10;
        boolean test = isBiggerThanTen.test(5);

        // Callable
        Callable<String> callable = () -> "Hello";
        String call = callable.call();
        System.out.println(call);
    }
}
