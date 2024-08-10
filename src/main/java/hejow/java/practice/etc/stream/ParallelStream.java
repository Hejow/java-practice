package hejow.java.practice.etc.stream;

import java.util.List;

public class ParallelStream {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		int sumOfSquares = numbers.parallelStream()
			.mapToInt(n -> n * n)
			.sum();

		System.out.println("Sum of squares: " + sumOfSquares);
	}
}
