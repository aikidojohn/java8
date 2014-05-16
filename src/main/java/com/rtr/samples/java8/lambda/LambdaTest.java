package com.rtr.samples.java8.lambda;

public class LambdaTest {

	public static interface BinaryOperation<A, B, R> {
		R apply(A a, B b);
	}

	public static <A, B, R> R compute(BinaryOperation<A, B, R> operation, A a, B b) {
		return operation.apply(a, b);
	}

	public static int add(int a, int b) {
		return a+ b;
	}
	
	public static void main(String... args) {
		int result = compute((a, b) -> a + b , 1, 2);
		
		System.out.println(result);
	}
}
