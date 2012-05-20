package com.putoet.tdd.enigma2;

public class EnigmaMachine {
	private final InputOutput io;
	private final Reflector reflector;
	private final Disk disks[];

	public EnigmaMachine(InputOutput io, Reflector reflector, Disk... disks) {
		validate(io, reflector, disks);

		this.io = io;
		this.reflector = reflector;
		this.disks = disks;
	}

	private void validate(InputOutput io, Reflector reflector, Disk... disks) {
		assert io.size() == reflector.size();
		for (int idx = 0; idx < disks.length; idx++) {
			assert io.size() == disks[idx].size();
		}
	}

	public String encode(String text) {
		StringBuilder encodedText = new StringBuilder();
		for (int idx = 0; idx < text.length(); idx++) {
			encodedText.append(encode(text.charAt(idx)));
		}
		return encodedText.toString();
	}

	private Character encode(char characterToEncode) {
		return (characterToEncode == ' ') ? characterToEncode
				: encodeNonBlank(characterToEncode);
	}

	private Character encodeNonBlank(char characterToEncode) {
		shift();
		int offset = io.indexOf(characterToEncode);
		offset = forward(offset);
		offset = reflector.reflect(offset);
		offset = backward(offset);

		return io.characterOf(offset);
	}

	private void shift() {
		if (disks.length > 0) {
			boolean shift = true;
			int idx = disks.length;
			while (shift && (idx > 0)) {
				shift = disks[--idx].shift();
			}
		}
	}

	private int forward(int offset) {
		for (int idx = disks.length - 1; idx >= 0; idx--) {
			offset = disks[idx].forward(offset);
		}
		return offset;
	}

	private int backward(int offset) {
		for (int idx = 0; idx < disks.length; idx++) {
			offset = disks[idx].backward(offset);
		}
		return offset;
	}

	protected String head() {
		StringBuilder heads = new StringBuilder();
		for (Disk disk : disks) {
			heads.append(disk.head().left());
		}
		return heads.toString();
	}
}
