package com.rtr.samples.java8.lambda.mycollection;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import com.rtr.samples.java8.AbstractFunctionalList;
import com.rtr.samples.java8.FunctionalList;

/**
 * A non-optimized implementation of some common functional list processing concepts.
 * 
 * DO NOT USE THIS - use Java's Stream API.
 * @author jhite
 *
 * @param <T>
 */
public class FunctionalListWrapper<T> extends AbstractFunctionalList<T> {
	
	public FunctionalListWrapper() {
		super();
	}
	public FunctionalListWrapper(List<T> base) {
		super(base);
	}
	
	@Override
	public <E> E foldLeft(E accumulator, BiFunction<E, T, E> function) {
		E result = accumulator;
		for (T elem : this) {
			result = function.apply(result, elem);
		}
		return result;
	}
	
	@Override
	public <E> E foldRight(E accumulator, BiFunction<E, T, E> function) {
		E result = accumulator;
		for (int i = this.size()-1; i >= 0; i--) {
			T elem = this.get(i);
			result = function.apply(result, elem);
		}
		return result;
	}

	@Override
	public <B> FunctionalList<B> map(Function<T, B> func) {
		FunctionalListWrapper<B> result = new FunctionalListWrapper<B>();
		for (T elem : this) {
			result.add(func.apply(elem));
		}
		return result;
	}
	
	@Override
	public FunctionalList<T> filter(Predicate<T> pred) {
		FunctionalListWrapper<T> filtered = new FunctionalListWrapper<T>();
		for (T elem : this) {
			if (pred.test(elem)) {
				filtered.add(elem);
			}
		}
		return filtered;
	}
}
