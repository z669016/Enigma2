package com.putoet.tdd.enigma2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReflectorTest {
	private final Reflector reflector = new Reflector("ABCDEFGDIJKGMKMIEBFTCVVJAT");
	
	@Test
	public void testReflect() {
		assertEquals(24, reflector.reflect(0));
		assertEquals(17, reflector.reflect(1));
		assertEquals(20, reflector.reflect(2));
		assertEquals(7, reflector.reflect(3));
		assertEquals(16, reflector.reflect(4));
		assertEquals(18, reflector.reflect(5));
		assertEquals(11, reflector.reflect(6));
		assertEquals(3, reflector.reflect(7));
		assertEquals(15, reflector.reflect(8));
		assertEquals(23, reflector.reflect(9));
		assertEquals(13, reflector.reflect(10));
		assertEquals(6, reflector.reflect(11));
		assertEquals(14, reflector.reflect(12));
		assertEquals(10, reflector.reflect(13));
		assertEquals(12, reflector.reflect(14));
		assertEquals(8, reflector.reflect(15));
		assertEquals(4, reflector.reflect(16));
		assertEquals(1, reflector.reflect(17));
		assertEquals(5, reflector.reflect(18));
		assertEquals(25, reflector.reflect(19));
		assertEquals(2, reflector.reflect(20));
		assertEquals(22, reflector.reflect(21));
		assertEquals(21, reflector.reflect(22));
		assertEquals(9, reflector.reflect(23));
		assertEquals(0, reflector.reflect(24));
		assertEquals(19, reflector.reflect(25));
	}

	
	@Test
	public void testSize() {
		assertEquals(26, reflector.size());
	}
}
