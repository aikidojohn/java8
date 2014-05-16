package com.rtr.samples.java8.lambda;

public class LambdaTest {

	public static interface BinaryOperation<A, B, R> {
		R apply(A a, B b);
	}
	
	public static interface BinaryOperation2<A, B, R> {
		R apply(A a, B b);
	}

	public static <A, B, R> R compute(BinaryOperation<A, B, R> operation, A a, B b) {
		System.out.println("1");
		return operation.apply(a, b);
	}
	
	public static int add(int a, int b) {
		return a+ b;
	}
	
	public int sub(int a, int b) {
		return a + b;
	}
	
	public static void main(String... args) {
		//Anonymous Lambda Expression
		int result = compute((a, b) -> a + b , 1, 2);
		System.out.println(result);
		
		result = compute((a, b) -> a * b , 1, 2);
		System.out.println(result);
		
		//Static method reference
		result = compute(LambdaTest::add, 3, 4);
		System.out.println(result);
		
		//Object method reference
		LambdaTest lambdaTest = new LambdaTest();
		result = compute(lambdaTest::sub, 3, 4);
		System.out.println(result);
	}
}
