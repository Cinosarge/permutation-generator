package com.permutation.app;

/**
 * Brings info about the custom character set to use and min and max size of dispositions.
 * 
 * Default constructor configures the object to generate dispositions of length 8 including
 * lowercase characters and numbers only. Any further modification will be made by use of
 * the setter methods.
 * 
 * @author - Enrico Sbrighi
 */
public class PermutationConfig {
	
	private int minLength;
	private int maxLength;
	
	private boolean number;
	private boolean lowerChar;
	private boolean upperChar;
	private boolean special;
	private boolean latin;
	
	private char[] customCharacters;
	
	public PermutationConfig() {
		this.minLength = 8;
		this.maxLength = 8;
		this.number = true;
		this.lowerChar = true;
		this.upperChar = false;
		this.special = false;
		this.latin = false;
		this.customCharacters = null;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public boolean hasNumber() {
		return number;
	}

	public void setNumber(boolean number) {
		this.number = number;
	}

	public boolean hasLowerChar() {
		return lowerChar;
	}

	public void setLowerChar(boolean lowerChar) {
		this.lowerChar = lowerChar;
	}

	public boolean hasUpperChar() {
		return upperChar;
	}

	public void setUpperChar(boolean upperChar) {
		this.upperChar = upperChar;
	}

	public boolean hasSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public boolean hasLatin() {
		return latin;
	}

	public void setLatin(boolean latin) {
		this.latin = latin;
	}
	
	public char[] getCustomCharacters() {
		return customCharacters;
	}

	public void setCustomCharacters(char[] customCharacters) {
		this.customCharacters = customCharacters;
	}
	
}
