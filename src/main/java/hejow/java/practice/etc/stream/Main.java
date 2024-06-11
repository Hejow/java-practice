package hejow.java.practice.etc.stream;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // Array Stream
        String[] strings = {"a", "b", "c"};
        Stream<String> arrayStream = Arrays.stream(strings);
        Stream<String> streamOfArrayPart = Arrays.stream(strings, 1, 3);

        // Collection Stream
        List<String> list = List.of("a", "b", "c");
        Stream<String> listStream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        // Empty Builder
        Stream<String> emptyStream = Stream.empty();

        // Stream Builder
        Stream<String> builderStream = Stream.<String>builder()
                .add("eric").add("elena").add("java")
                .build();

        // Stream.generate()
        Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5);

        // Stream.iterate()
        Stream<Integer> iteratedStream = Stream.iterate(30, n -> n + 2).limit(5);

        // Basic Type Stream
        IntStream intStream = IntStream.range(1, 5);
        LongStream longStream = LongStream.rangeClosed(1, 5);

        Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed(); // boxing

        DoubleStream doubles = new Random().doubles(3); // random returns DoubleStream

        // String Stream
        IntStream charsStream = "Stream".chars();
        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("Eric, Elena, Java");

        // File Stream
//        Stream<String> lineStream = Files.lines(Paths.get("files.txt"), StandardCharsets.UTF_8);

        // Parallel Stream
        Stream<String> parallelStream1 = list.parallelStream();
        boolean isParallel = parallelStream1.isParallel();

        IntStream intStream2 = IntStream.range(1, 150).parallel();
        boolean isParallel2 = intStream2.isParallel();

        IntStream intStream3 = intStream2.sequential();
        boolean isParallel3 = intStream3.isParallel(); // false

        // Concat Stream
        Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
        Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
        Stream<String> concat = Stream.concat(stream1, stream2);

        List<String> names = List.of("Eric", "Elena", "Java");

        // Filtering
        Stream<String> filteringStream = names.stream()
                .filter(name -> name.contains("a"));

        // Mapping
        Stream<String> mappingStream = names.stream()
                .map(String::toUpperCase);

        List<List<String>> overlapedList = List.of(List.of("a"), List.of("b"));
        List<String> flatList = overlapedList.stream()
                .flatMap(Collection::stream)
                .toList(); // {"a", "b"}

        // Sorting
        List<Integer> collected = IntStream.of(14, 11, 20, 39, 23)
                .sorted()
                .boxed()
                .toList();

        List<String> lang = List.of("Java", "Scala", "Groovy", "Python", "Go", "Swift");
        List<String> sortedLang = lang.stream()
                .sorted()
                .toList();

        List<String> reversedLang = lang.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        // Iterating
        int sum = IntStream.of(1, 3, 5, 7, 9)
                .peek(System.out::println) // recommend foreach than peek
                .sum();

        // Calculating
        long count = IntStream.of(1, 3, 5, 7, 9).count();
        long longSum = LongStream.of(1, 3, 5, 7, 9).sum();


        // Reduction
        OptionalInt reduced = IntStream.range(1, 4)
                .reduce(Integer::sum);

        int combinerWasCalled = List.of(1, 2, 3)
                .parallelStream()
                .reduce(10, Integer::sum, (a, b) -> {
                    System.out.println("combiner was called"); // Combiner works on parallel
                    return a + b;
                });

        // Collecting
        List<Product> productList =
                List.of(new Product(23, "potatoes"),
                        new Product(14, "orange"),
                        new Product(13, "lemon"),
                        new Product(23, "bread"),
                        new Product(13, "sugar"));

        // toList()
        List<String> productNameList = productList.stream()
                .map(Product::name)
                .toList();

        // joining()
        String collectedNames = productList.stream()
                .map(Product::name)
                .collect(Collectors.joining());

        String collectedWithDelimiter = productList.stream()
                .map(Product::name)
                .collect(Collectors.joining(",", "<", ">"));

        // averagingInt()
        Double averageAmount = productList.stream()
                .collect(Collectors.averagingInt(Product::amount));

        // summingInt()
        int summingAmount = productList.stream()
                .collect(Collectors.summingInt(Product::amount));
        // int summingAmount = productList.stream().mapToInt(Product::amount).sum();

        int summingAmount2 = productList.stream()
                .mapToInt(Product::amount)
                .sum();

        // summarizingInt()
        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::amount));

        // groupingBy()
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::amount));

        // partitioningBy()
        Map<Boolean, List<Product>> mapPartitioned = productList.stream()
                .collect(Collectors.partitioningBy(p -> p.amount() > 15));

        // collectingAndThen()
        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

        // of()
        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new,
                        LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedList = productList.stream()
                .collect(toLinkedList);

        // Matching (anyMatch, allMatch, noneMatch)
        boolean anyMatch = names.stream()
                .anyMatch(name -> name.contains("a")); // true
        boolean allMatch = names.stream()
                .allMatch(name -> name.length() > 3); // true
        boolean noneMatch = names.stream()
                .noneMatch(name -> name.endsWith("s")); // true

        // Iterating
        names.forEach(System.out::println);
    }
}
