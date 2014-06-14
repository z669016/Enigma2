package com.putoet.tdd.enigma2;

public class LetterPair {
	private final char right;
	private final char left;
	private final boolean notch;

	public LetterPair(char left, char right) {
		this(left, right, false);
	}

	public LetterPair(char left, char right, boolean notch) {
		this.right = right;
		this.left = left;
		this.notch = notch;
	}

	public char right() {
		return right;
	}

	public char left() {
		return left;
	}

	public boolean notch() {
		return notch;
	}

	@Override
	public String toString() {
		return "[left: " + left + ", right: " + right + ", notch: " + notch
				+ "]";
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof LetterPair)
                && (left == ((LetterPair) other).left)
				&& (right == ((LetterPair) other).right)
				&& (notch == ((LetterPair) other).notch);
	}
}
