package com.permutation.utils;

public class CharsetModifiers {
	/**
	 * Delete the duplicated characters from the character set.
	 * @param charset charset to remove duplicated characters from.
	 * 
	 * @author Enrico Sbrighi
	 */
	public static void removeDuplicates(String charset) {
		for(int i = 0; i < charset.length(); i++) {
			int lastIndex = charset.lastIndexOf(charset.charAt(i));
			while(i != lastIndex) {
				String firstPart = charset.substring(0, lastIndex);
				String secondPart = charset.substring(lastIndex + 1, charset.length());
				charset = firstPart;
				charset += secondPart;
			}
		}
	}
}
