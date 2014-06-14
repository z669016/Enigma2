package com.putoet.tdd.enigma2;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Disk {
	private final List<LetterPair> pairs;
	
	protected Disk(List<LetterPair> pairs) {
		this.pairs = pairs;
	}
	
	public int size() {
		return pairs.size();
	}

    public LetterPair head() {
        return pairs.get(0);
    }
    public String headLetter() {
        return String.valueOf(pairs.get(0).left());
    }

	public LetterPair get(int offset) {
		return pairs.get(offset);
	}

	public Boolean shift() {
		LetterPair pair = pairs.remove(0);
		pairs.add(pair);
		return pair.notch();
	}

	public boolean reset(char left) {
		LetterPair first = pairs.get(0);
	
		do {
			shift();
		} while ((pairs.get(0).left() != left) && (pairs.get(0) != first));
		
		return (pairs.get(0).left() == left);
	}

	public int rightIndexOf(final char right) {
		return indexOf(pair -> pair.right() == right);
	}

	public int leftIndexOf(final char left) {
		return indexOf(pair -> pair.left() == left);
	}
	
	private int indexOf(Predicate<LetterPair> finder) {
		Iterator<LetterPair> pairIterator = pairs.iterator();
		int idx = 0;
		while (pairIterator.hasNext()) {
			if (finder.test(pairIterator.next())) {
				return idx;
			}
			idx++;
		}
		return -1;
	}
	
	public int forward(int rightIndex) {
		char left = pairs.get(rightIndex).right();
		return leftIndexOf(left);
	}
	
	public int backward(int leftIndex) {
		char right = pairs.get(leftIndex).left();
		return rightIndexOf(right);
	}
}
