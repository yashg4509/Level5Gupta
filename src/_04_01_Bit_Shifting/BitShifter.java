package _04_01_Bit_Shifting;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		int num = 4;
		int numShifted = num << 1;

		// 2. Print the value of numShifted, and convert that value to binary.
		System.out.println(numShifted);
		String binaryShiftedStr = Integer.toBinaryString(numShifted);
		// 3. Compare the two binary values. Can you figure out what the << operator is
		// for?
		String binaryStr = Integer.toBinaryString(num);
		System.out.println(binaryStr);
		if (binaryStr.equals(binaryShiftedStr)) {
			System.out.println("They are equal.");
		} else {
			System.out.println("They aren't equal.");
		}
		// 4. Try shifting num 3 places.
		int numShifted2 = num << 3;
		String binaryShiftedStr2 = Integer.toBinaryString(numShifted2);
		System.out.println(binaryShiftedStr2);
		// FYI: Binary values can be shifted to the right as well using the >> operator.
	}
}
