package com.putoet.tdd.enigma2;

import java.util.LinkedList;
import java.util.List;

public class DiskBuilder {
	private final List<LetterPair> pairs = new LinkedList<>();
	
	public int size() {
		return pairs.size();
	}

	public DiskBuilder add(char left, char right) {
		pairs.add(new LetterPair(left, right));
		return this;
	}
	
	public DiskBuilder add(char left, char right, boolean notch) {
		pairs.add(new LetterPair(left, right, notch));
		return this;
	}
	
	public DiskBuilder add(LetterPair letterPair) {
		pairs.add(letterPair);
		return this;
	}
	
	protected LetterPair[] getPairs() { 
		return pairs.toArray(new LetterPair[pairs.size()]);
	}
	
	public Disk build() {
		return new Disk(pairs);
	}
}
