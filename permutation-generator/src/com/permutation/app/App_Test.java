package com.permutation.app;

import com.permutation.model.Permutation;

public class App_Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * It is used to configure the generator to make length 8
		 * alphanumerical permutations.
		 */
		PermutationConfig cfg = new PermutationConfig();
		
		/*
		 * Now it is configured to use alphabetical characters only.
		 * For more options see DispositionConfig docs.
		 */
		cfg.setNumber(false);
		cfg.setLowerChar(false);
		//cfg.setUpperChar(true);
		cfg.setCustomCharacters(new char[] {'a', 'b', 'c', 'd'});
		cfg.setMinLength(3);
		cfg.setMaxLength(3);
		
		/*
		 * Configured permutation generator.
		 */
		PermutationGenerator gen = new PermutationGenerator(cfg);
		
		
		while(true) {
			Permutation disp = gen.getNextPermutation();
			
			if(disp == null) {
				System.out.println("Done.");
				return;
			}
			else {
				System.out.println(disp.toString());
			}
			
			//new java.util.Scanner(System.in).nextLine();
		}
	}

}
