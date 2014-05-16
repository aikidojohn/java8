package com.rtr.samples.java8.lambda.stream;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.IntConsumer;

public class StreamTest {
	
	public static void main(String... args) {
		List<Integer>  numbers = new LinkedList<>();
		for (int i =1; i< 4; i++) {
			numbers.add(i);
		}
		
		Averager avg = numbers.stream().parallel()
				.collect(Averager::new, Averager::accept, Averager::combine);
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
