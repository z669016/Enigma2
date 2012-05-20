package com.putoet.tdd.enigma2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DiskTest {
	private static final LetterPair LETTER_PAIR_1 = new LetterPair('A', 'D');
	private static final LetterPair LETTER_PAIR_2 = new LetterPair('B', 'C', true);
	private static final LetterPair LETTER_PAIR_3 = new LetterPair('C', 'B');
	private static final LetterPair LETTER_PAIR_4 = new LetterPair('D', 'A');

	private Disk disk;

	@Before
	public void setup() {
		disk = new DiskBuilder().add(LETTER_PAIR_1).add(LETTER_PAIR_2)
				.add(LETTER_PAIR_3).add(LETTER_PAIR_4).build();
	}

	@Test
	public void testSize() {
		assertEquals(4, disk.size());
	}
	
	@Test
	public void testGet() {
		assertEquals(LETTER_PAIR_1, disk.head());
		assertEquals(LETTER_PAIR_2, disk.get(1));
		assertEquals(LETTER_PAIR_3, disk.get(2));
		assertEquals(LETTER_PAIR_4, disk.get(3));
	}
	
	@Test
	public void testShift() {
		assertFalse(disk.shift());
		assertEquals(LETTER_PAIR_2, disk.head());
		assertEquals(LETTER_PAIR_3, disk.get(1));
		assertEquals(LETTER_PAIR_4, disk.get(2));
		assertEquals(LETTER_PAIR_1, disk.get(3));
	}
	
	@Test
	public void testNotch() {
		assertFalse(disk.shift());
		assertTrue(disk.shift());
		assertFalse(disk.shift());
		assertFalse(disk.shift());
		assertFalse(disk.shift());
		assertTrue(disk.shift());
		assertFalse(disk.shift());
		assertFalse(disk.shift());
	}
	
	@Test
	public void testResetTrue() {
		assertTrue(disk.reset(LETTER_PAIR_3.left()));
		assertEquals(LETTER_PAIR_3, disk.head());
		assertTrue(disk.reset(LETTER_PAIR_3.left()));
		assertEquals(LETTER_PAIR_3, disk.head());
	}

	@Test
	public void testResetFalse() {
		assertFalse(disk.reset('Q'));
		assertEquals(LETTER_PAIR_1, disk.head());
	}
	
	@Test
	public void testRightIndexOf() {
		assertEquals(0, disk.rightIndexOf(LETTER_PAIR_1.right()));
		assertEquals(1, disk.rightIndexOf(LETTER_PAIR_2.right()));
		assertEquals(2, disk.rightIndexOf(LETTER_PAIR_3.right()));
		assertEquals(3, disk.rightIndexOf(LETTER_PAIR_4.right()));
		assertEquals(-1, disk.rightIndexOf('Q'));
	}
	
	@Test
	public void testLeftIndexOf() {
		assertEquals(0, disk.leftIndexOf(LETTER_PAIR_1.left()));
		assertEquals(1, disk.leftIndexOf(LETTER_PAIR_2.left()));
		assertEquals(2, disk.leftIndexOf(LETTER_PAIR_3.left()));
		assertEquals(3, disk.leftIndexOf(LETTER_PAIR_4.left()));
		assertEquals(-1, disk.leftIndexOf('Q'));
	}
	
	@Test
	public void testForward() {
		assertEquals(3, disk.forward(0));
		assertEquals(2, disk.forward(1));
		assertEquals(1, disk.forward(2));
		assertEquals(0, disk.forward(3));
	}
	
	@Test
	public void testBackward() {
		assertEquals(3, disk.backward(0));
		assertEquals(2, disk.backward(1));
		assertEquals(1, disk.backward(2));
		assertEquals(0, disk.backward(3));
	}
}
