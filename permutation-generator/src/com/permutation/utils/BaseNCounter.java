package com.permutation.utils;

/**
 * Generates base n numbers. Numbers are stored as an integer vector and each element represents
 * a number's cipher as an integer in [0, n-1].
 * 
 * An object from this class has a status that is the current number from which one can obtain the
 * next one.
 * 
 * Take into account that each cipher is stored as a signed int variable, making it clear that n is at most
 * n = 2^(16-1) - 2 = 2.147.483.646 . Notice it's minus two and not minus one becaus of an implementation
 * peculiarity.
 * 
 * @author Enrico Sbrighi
 */
public class BaseNCounter {
	private int base;
	private int[] currentNumber;
	
	public BaseNCounter() {
		this.base = 10;
		this.currentNumber = new int[] {0};
	}
	
	public BaseNCounter(int base, int[] startFromNumber) {
		this.base = base;
		this.currentNumber = startFromNumber;
	}
	
	public int[] getCurrentNumber() {
		return currentNumber;
	}
	
	public void setCurrentNumber(int[] currentNumber) {
		this.currentNumber = currentNumber;
	}
	
	public int[] computeNextNumber() {
		int[] nextNumber = currentNumber;
		nextNumber[0] += 1;
		
		if(nextNumber[0] == base) {
			// There's a carryover
			boolean carryover = true;
			nextNumber[0] = 0;
			
			int length = nextNumber.length;
			int cipherIndex = 1;
			do {
				if(cipherIndex == length) {
					// Add one more cipher
					int[] tmpNumber = new int[length + 1] ;
					tmpNumber[length] = 0;
					// Copy the old number into the new one
					for(int k = 0; k <= length - 1; k++) {
						tmpNumber[k] = nextNumber[k];
					}
					nextNumber = tmpNumber;
					length = nextNumber.length;
				}
				
				carryover = false;
				
				nextNumber[cipherIndex] +=1;
				if(nextNumber[cipherIndex] == base) {
					nextNumber[cipherIndex] = 0;
					carryover = true;
				}
				cipherIndex++;
			} while(cipherIndex <= length && carryover);
			
			currentNumber = nextNumber;
		}
		
		return nextNumber;
	}
}
