package com.permutation.app;

import com.permutation.exception.EmptyCharsetException;
import com.permutation.model.Permutation;
import com.permutation.utils.BaseNCounter;
import com.permutation.utils.CharsetModifiers;

/**
 * Generates character dispositions.
 * 
 * @author Enrico Sbrighi
 */
public class PermutationGenerator {
	// Configuration objecdt.
	private PermutationConfig cfg;
	// Set of character to use to generate dispositions.
	private String charset;
	
	BaseNCounter counter = null;
	
	public PermutationGenerator(PermutationConfig cfg) {
		this.cfg = cfg;
		buildCharset(cfg);
		
		/*
		 * A counter brings the state of the current "number".
		 * It has to be global.
		 */
		int charsetLength = charset.length();
		int[] startNumber = new int[cfg.getMinLength()];
		
		for (int i = 0; i < cfg.getMinLength(); i++)
			startNumber[i] = 0;
		
		counter = new BaseNCounter(charsetLength, startNumber);
	}
	
	/**
	 * Get the next Disposition.
	 * @return
	 */
	public Permutation getNextPermutation() {
		/*
		 * Given n = lengthOf(character_set), there is a bijection between the set of character
		 * dispositions of length k and the set of numbers base n having k ciphers. Therefore
		 * we can use a base-n counter to calculate the next base-n number and use each cipher
		 * as access index to a ordered data structure containing the characters.
		 */
		Permutation nextDisposition = new Permutation();
		
		int minLength = cfg.getMinLength();
		int maxLength = cfg.getMaxLength();
		if(minLength < maxLength)
			throw new RuntimeException(); // TODO - Crea una eccezione apposita.
		
		int[] nextNumber = counter.computeNextNumber();
		
		if(nextNumber.length > maxLength)
			return null; // Done.
		
		// Ogni cifra è usata per accedere il charset e viene realizzata la corrispondente permutazione.
		char[] nextPermutation = new char[nextNumber.length];
		for(int i = 0; i < nextPermutation.length; i++) {
			nextPermutation[i] = charset.charAt(nextNumber[i]);
		}
		
		nextDisposition.setPermutation(nextPermutation);
		return nextDisposition;
	}
	
	/*
	 * Build the charset using the configuration object.
	 */
	private void buildCharset(PermutationConfig cfg) {
		charset = "";
		if(cfg.hasNumber())
			charset += "0123456789";
		if(cfg.hasLowerChar())
			charset += "abcdefghijklmnopqrstuvwxyz";
		if(cfg.hasUpperChar())
			charset += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if(cfg.hasSpecial())
			charset += "\"\\!£$%&=?'^()[]{}.,;:_-+*/§@#";
		if(cfg.hasLatin())
			charset += "àèéìòù";
		if(cfg.getCustomCharacters() != null)
			charset += String.copyValueOf(cfg.getCustomCharacters());
		if(charset.isEmpty()) {
			throw new EmptyCharsetException("The specified charset is empty.");
		}
		CharsetModifiers.removeDuplicates(charset);
	}
}
