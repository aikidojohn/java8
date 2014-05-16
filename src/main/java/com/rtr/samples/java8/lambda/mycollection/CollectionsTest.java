package com.rtr.samples.java8.lambda.mycollection;

import com.rtr.samples.java8.FunctionalList;

public class CollectionsTest {

	public static void main(String... args) {
		FunctionalList<Integer>  numbers = new FunctionalListWrapper<>();
		for (int i =1; i< 4; i++) {
			numbers.add(i);
		}
	}
}
