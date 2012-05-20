package com.putoet.tdd.enigma2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnigmaMachineTest {
	private final InputOutput io = new InputOutput("ABCDEFGH");
	private final Reflector reflector = new Reflector("ABCDDCBA");
	private final Disk simpleDisk = new DiskBuilder().add('A', 'A', true).add('B', 'B')
			.add('C', 'C').add('D', 'D').add('E', 'E').add('F', 'F')
			.add('G', 'G').add('H', 'H').build();
	private final Disk forwardDisk = new DiskBuilder().add('H', 'A', true).add('G', 'B')
			.add('F', 'C').add('E', 'D').add('D', 'E').add('C', 'F')
			.add('B', 'G').add('A', 'H').build();
	private final Disk backwardDisk = new DiskBuilder().add('A', 'H', true).add('B', 'G')
			.add('C', 'F').add('D', 'E').add('E', 'D').add('F', 'C')
			.add('G', 'B').add('H', 'A').build();

	@Test
	public void testEncode() {
		EnigmaMachine enigma = new EnigmaMachine(io, reflector);
		assertEquals("HGFE DCBA", enigma.encode("ABCD EFGH"));
	}

	@Test
	public void testEncodeSimpleDisk() {
		EnigmaMachine enigma = new EnigmaMachine(io, reflector, simpleDisk);
		assertEquals("HGFEDCBA", enigma.encode("ABCDEFGH"));
	}

	@Test
	public void testEncodeBackwardForwardSimpleDisk() {
		EnigmaMachine enigma = new EnigmaMachine(io, reflector, backwardDisk, forwardDisk, simpleDisk);
		assertEquals("AHA", enigma.head());
		assertEquals("HGFEDCBA", enigma.encode("ABCDEFGH"));
		assertEquals("BGA", enigma.head());
	}
}
