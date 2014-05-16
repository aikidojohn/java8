package com.rtr.samples.java8.lambda.stream;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class StreamTest {
	
	public static void main(String... args) {
		List<Integer>  numbers = new LinkedList<>();
		for (int i =1; i< 4; i++) {
			numbers.add(i);
		}
		
		//Sum the list
		int sum = numbers.stream().reduce(0, (a,b) -> a+ b);
		System.out.println(sum);

		//Product of the list
		int product = numbers.stream().reduce(1, (a,b) -> a * b);
		System.out.println(product);

		//add 2 to every element and compute the product.
		int result = numbers.stream().map((e) -> e + 2).reduce(1, (a,b) -> a * b);
		System.out.println(result);

		//collect all elements into a Set. 
		//This performs a reduction that uses Set::add to add elements to a new HashSet (constructed by HashSet::new)
		Set<Integer> set = numbers.stream().collect(HashSet::new, Set::add, Set::addAll);
		System.out.println(set);

		//Add 2 to every element and collect into a List.
		List<String> mapped = numbers.stream().map((e) -> String.valueOf(e+2)).collect(Collectors.toList());
		System.out.println(mapped);

		//Collect all odd numbers into a List;
		List<Integer> odd = numbers.stream().filter((e) -> e % 2 != 0 ).collect(Collectors.toList());
		System.out.println(odd);
		
		//Compute an average of all elements in the stream using a Parallel Stream
		Averager avg = numbers.stream().parallel().collect(Averager::new, Averager::accept, Averager::combine);
		System.out.println(avg.average());
	}
	
	
	public static class Averager implements IntConsumer
	{
	    private int total = 0;
	    private int count = 0;
	    
	    public Averager() {
	    	System.out.println("Averager::new");
	    }
	        
	    public double average() {
	        return count > 0 ? ((double) total)/count : 0;
	    }
	        
	    public void accept(int i) {
	    	System.out.println("Averager::accept");
	    	total += i; count++; 
	    }
	    public void combine(Averager other) {
	    	System.out.println("Averager::combine");
	        total += other.total;
	        count += other.count;
	    }
	}
}
