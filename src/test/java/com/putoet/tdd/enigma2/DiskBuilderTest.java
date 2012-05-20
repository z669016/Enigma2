package com.putoet.tdd.enigma2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class DiskBuilderTest {
	private static final LetterPair LETTER_PAIR_1 = new LetterPair('A', 'B');
	private static final LetterPair LETTER_PAIR_2 = new LetterPair('C', 'D', true);
	private static final LetterPair LETTER_PAIR_3 = new LetterPair('E', 'F');
	private static final LetterPair LETTER_PAIR_4 = new LetterPair('G', 'H');

	private DiskBuilder diskBuilder;

	@Before
	public void setup() {
		diskBuilder = new DiskBuilder();
	}

	@Test
	public void testAdd() {
		assertEquals(0, diskBuilder.size());
		diskBuilder.add(LETTER_PAIR_1).add(LETTER_PAIR_2);
		assertEquals(2, diskBuilder.size());
	}

	@Test
	public void testAddNoObjects() {
		assertEquals(0, diskBuilder.size());
		diskBuilder.add('A', 'B').add('C', 'D', true);
		assertEquals(2, diskBuilder.size());
		
		LetterPair pairs[] = diskBuilder.getPairs();
		assertEquals(pairs[0], LETTER_PAIR_1);
		assertEquals(pairs[1], LETTER_PAIR_2);
	}

	@Test
	public void testBuild() {
		LetterPair pairs[] = diskBuilder.add(LETTER_PAIR_1).add(LETTER_PAIR_2)
				.add(LETTER_PAIR_3).add(LETTER_PAIR_4).getPairs();
		
		assertSame(pairs[0], LETTER_PAIR_1);
		assertSame(pairs[1], LETTER_PAIR_2);
		assertSame(pairs[2], LETTER_PAIR_3);
		assertSame(pairs[3], LETTER_PAIR_4);
	}
}
