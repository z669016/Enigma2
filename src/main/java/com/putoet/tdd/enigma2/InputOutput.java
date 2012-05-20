package com.putoet.tdd.enigma2;

public final class InputOutput {
	private final String inputOutput;
	
	public InputOutput(final String inputOutput) {
		this.inputOutput = inputOutput;
	}
	
	public int indexOf(Character characterToFind) {
		return inputOutput.indexOf(characterToFind);
	}
	
	public char characterOf(Integer index) {
		return inputOutput.charAt(index);
	}
	
	public int size() {
		return inputOutput.length();
	}
}
