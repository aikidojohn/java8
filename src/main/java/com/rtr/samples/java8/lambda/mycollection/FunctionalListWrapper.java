package com.rtr.samples.java8.lambda.mycollection;

import java.util.List;

import com.rtr.samples.java8.AbstractFunctionalList;

public class FunctionalListWrapper<T> extends AbstractFunctionalList<T> {
	
	public FunctionalListWrapper() {
		super();
	}
	public FunctionalListWrapper(List<T> base) {
		super(base);
	}
}
