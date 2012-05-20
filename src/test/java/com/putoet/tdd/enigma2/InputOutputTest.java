package com.putoet.tdd.enigma2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InputOutputTest {
	private final InputOutput io = new InputOutput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	
	@Test
	public void testSize() {
		assertEquals(26, io.size());
	}
	

	@Test
	public void testIndexOf() {
		for (int i = 0; i < 26; i++) {
			assertEquals("Expect index of " + (char)('A' + i) + " to be " + i, i, io.indexOf((char)('A' + i)));
		}
	}
	
	@Test
	public void testCharacterOf() {
		for (int i = 0; i < 26; i++) {
			assertEquals("Expect character of " + i + " to be " +  (char)('A' + i), (char)('A' + i), io.characterOf(i));
		}
	}
}
