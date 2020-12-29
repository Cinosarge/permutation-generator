package com.permutation.model;

/**
 * Generic character permutation.
 * 
 * @author Enrico Sbrighi
 */
public class Permutation {
	private char[] permutation;
	
	public Permutation() {
		
	}
	
	public char[] getPermutation() {
		return permutation;
	}
	
	public void setPermutation(char[] text) {
		this.permutation = text;
	}

	@Override
	public String toString() {
		String dispString = "";
		for(int i = permutation.length - 1; i >= 0; i--)
			dispString += permutation[i];
		return dispString;
	}
	
}
