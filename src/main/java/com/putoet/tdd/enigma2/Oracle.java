package com.putoet.tdd.enigma2;

public class Oracle {

	public static void main(String[] args) {
		InputOutput io = new InputOutput("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		Reflector reflector = new Reflector("ABCDEFGDIJKGMKMIEBFTCVVJAT");
		Disk disk1 = new DiskBuilder().add('A', 'E').add('B', 'K')
				.add('C', 'M').add('D', 'F').add('E', 'L').add('F', 'G')
				.add('G', 'D').add('H', 'Q').add('I', 'V').add('J', 'Z')
				.add('K', 'N').add('L', 'T').add('M', 'O').add('N', 'W')
				.add('O', 'Y').add('P', 'H').add('Q', 'X', true).add('R', 'U')
				.add('S', 'S').add('T', 'P').add('U', 'A').add('V', 'I')
				.add('W', 'B').add('X', 'R').add('Y', 'C').add('Z', 'J')
				.build();
		Disk disk2 = new DiskBuilder().add('A', 'A').add('B', 'J')
				.add('C', 'D').add('D', 'K').add('E', 'S', true).add('F', 'I')
				.add('G', 'R').add('H', 'U').add('I', 'X').add('J', 'B')
				.add('K', 'L').add('L', 'H').add('M', 'W').add('N', 'T')
				.add('O', 'M').add('P', 'C').add('Q', 'Q').add('R', 'G')
				.add('S', 'Z').add('T', 'N').add('U', 'P').add('V', 'Y')
				.add('W', 'F').add('X', 'V').add('Y', 'O').add('Z', 'E')
				.build();
		Disk disk3 = new DiskBuilder().add('A', 'B').add('B', 'D')
				.add('C', 'F').add('D', 'H').add('E', 'J').add('F', 'L')
				.add('G', 'C').add('H', 'P').add('I', 'R').add('J', 'T')
				.add('K', 'X').add('L', 'V').add('M', 'Z').add('N', 'N')
				.add('O', 'Y').add('P', 'E').add('Q', 'I').add('R', 'W')
				.add('S', 'G').add('T', 'A').add('U', 'K').add('V', 'M', true)
				.add('W', 'U').add('X', 'S').add('Y', 'Q').add('Z', 'O')
				.build();
		
		disk1.reset('M');
		disk2.reset('C');
		disk3.reset('K');
		
		EnigmaMachine enigma = new EnigmaMachine(io, reflector, disk1, disk2, disk3);
		String text = "QMJIDO MZWZJFJR";
		printEncodedText(enigma, text);
		
		disk1.reset('M');
		disk2.reset('C');
		disk3.reset('K');
		
		text = "ENIGMA REVEALED";
		printEncodedText(enigma, text);
	}

	private static void printEncodedText(EnigmaMachine enigma, String text) {
		String encodedText = enigma.encode(text);
		System.out.printf("'%s' encodes to '%s'\n", text, encodedText);
	}
}
