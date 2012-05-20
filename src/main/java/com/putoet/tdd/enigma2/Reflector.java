package com.putoet.tdd.enigma2;

public class Reflector {
	private final String reflector;

	public Reflector(String reflector) {
		this.reflector = reflector;
	}
	
	public int reflect(Integer toReflect) {
		Character charToReflect = reflector.charAt(toReflect);
		
		int first = reflector.indexOf(charToReflect);
		int last = reflector.lastIndexOf(charToReflect);
		
		return (first == toReflect ? last : first);
	}
	
	public int size() {
		return reflector.length();
	}
}
