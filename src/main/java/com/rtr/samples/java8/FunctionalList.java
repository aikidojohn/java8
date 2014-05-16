package com.rtr.samples.java8;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FunctionalList<T> extends List<T> {
	
	public <E> E foldLeft(E accumulator, BiFunction<E, T, E> function);

	public <E> E foldRight(E accumulator, BiFunction<E, T, E> function);

	public <B> FunctionalList<B> map(Function<T, B> func);

	public FunctionalList<T> filter(Predicate<T> pred);
}
