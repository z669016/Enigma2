package com.putoet.tdd.enigma2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LetterPairTest {
	@Test
	public void testDefault() {
		LetterPair pair = new LetterPair('A', 'B');
		assertEquals('A', pair.left());
		assertEquals('B', pair.right());
		assertFalse(pair.notch());
	}
	
	@Test
	public void testFalse() {
		LetterPair pair = new LetterPair('A', 'B', false);
		assertEquals('A', pair.left());
		assertEquals('B', pair.right());
		assertFalse(pair.notch());
	}

	@Test
	public void testTrue() {
		LetterPair pair = new LetterPair('A', 'B', true);
		assertEquals('A', pair.left());
		assertEquals('B', pair.right());
		assertTrue(pair.notch());
	}
	
	@Test
	public void testToString() {
		assertEquals("[left: A, right: B, notch: false]", new LetterPair('A', 'B').toString());
		assertEquals("[left: A, right: B, notch: true]", new LetterPair('A', 'B', true).toString());
	}
	
	@Test
	public void testEqualsTrue() {
		LetterPair pair1 = new LetterPair('A', 'B');
		LetterPair pair2 = new LetterPair('A', 'B');
		assertTrue(pair1.equals(pair2));
		assertTrue(pair1.equals((Object) pair2));
	}
	
	@Test
	public void testEqualsFalse() {
		LetterPair pair1 = new LetterPair('A', 'B');
		LetterPair pair2 = new LetterPair('A', 'B', true);
		LetterPair pair3 = new LetterPair('A', 'C');
		LetterPair pair4 = new LetterPair('B', 'B');
		
		assertFalse(pair1.equals(pair2));
		assertFalse(pair1.equals(pair3));
		assertFalse(pair1.equals(pair4));
		assertFalse(pair1.equals(new Object()));
	}
}
