package _02_01_Lambda_Methods;

import java.util.Random;

public class LambdaMethods {
	public static void main(String[] args) {
		// 1. Look at the SpecialPrinter function interface.

		// Here is an example of calling the printCustomMessage method with a lambda.
		// This prints the passed in String 10 times.
		printCustomMessage((s) -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(s);
			}
		}, "repeat");
		System.out.println("=============================================================================");
		// 2. Call the printCustonMessage method using a lambda so that the String
		// prints backwards.
		printCustomMessage((s) -> {
			char[] temp = s.toCharArray();
			int left, right = temp.length - 1;

			for (left = 0; left < right; left++, right--) {
				char c = temp[left];
				temp[left] = temp[right];
				temp[right] = c;
			}

			for (char x : temp) {
				System.out.print(x);
			}
			System.out.println();

		}, "repeat");
		System.out.println("=============================================================================");
		// 3. Call the printCustonMessage method using a lambda so that the String
		// prints with a mix between upper an lower case characters.
		printCustomMessage((s) -> {
			Random r = new Random();
			int rnd;

			for (int i = 0; i < s.length(); i++) {
				rnd = r.nextInt(2);
				if (rnd == 1) {
					s = s.substring(0, i) + s.substring(i, i + 1).toUpperCase() + s.substring(i + 1, s.length());
				}
			}

			System.out.println(s);
		}, "repeat");
		System.out.println("=============================================================================");
		// 4. Call the printCustonMessage method using a lambda so that the String
		// prints with a period in between each character.
		printCustomMessage((s) -> {
			String res = "";

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				res += c + ".";
			}
			System.out.println(res);

		}, "repeat");
		// 5. Call the printCustonMessage method using a lambda so that the String
		// prints without any vowels.
		printCustomMessage((s) -> {
			String res = "";

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')) {

				}
			}
			System.out.println(res);

		}, "repeat");

	}

	public static void printCustomMessage(SpecialPrinter sp, String value) {
		sp.printSpecial(value);
	}
}
