package com.rtr.samples.java8;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFunctionalList<T> extends AbstractList<T> implements FunctionalList<T> {
	private final List<T> base;
	
	public AbstractFunctionalList() {
		super();
		this.base = new ArrayList<T>();
	}
	public AbstractFunctionalList(List<T> base) {
		super();
		this.base = base;
	}
	
	@Override
	public T get(int index) {
		return base.get(index);
	}

	@Override
	public int size() {
		return base.size();
	}
	
	@Override
	public void add(int index, T element) {
        base.add(element);
    }
}
