package com.rtr.samples.java8.lambda.mycollection;

import com.rtr.samples.java8.FunctionalList;

public class CollectionsTest {

	public static void main(String... args) {
		FunctionalList<Integer>  numbers = new FunctionalListWrapper<>();
		for (int i =1; i< 4; i++) {
			numbers.add(i);
		}
		
		//Sum of list
		int sum = numbers.foldLeft(0, (a,b) -> a+ b);
		System.out.println(sum);

		//Product of list
		int product = numbers.foldLeft(1, (a,b) -> a * b);
		System.out.println(product);

		//Reverse the list
		FunctionalList<Integer> reversed = numbers.foldRight(new FunctionalListWrapper<Integer>(), (r, e) -> { r.add(e); return r; });
		System.out.println(reversed);

		//add 2 to every element and convert to a string
		FunctionalList<String> mapped = numbers.map((e) -> String.valueOf(e+2));
		System.out.println(mapped);

		//Add 2 to all members of the list then compute the product
		int result = numbers.map((e) -> e + 2).foldLeft(1, (a,b) -> a * b);
		System.out.println(result);

		//Return a lost of only odd numbers		
		FunctionalList<Integer> odd = numbers.filter((e) -> e % 2 != 0 );
		System.out.println(odd);
	}
}
