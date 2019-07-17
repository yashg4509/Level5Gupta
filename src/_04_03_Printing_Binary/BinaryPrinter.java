package _04_03_Printing_Binary;

public class BinaryPrinter {
	// Complete the methods below so they print the passed in parameter in binary.
	// Don't be afraid to use the methods that are already complete to finish the
	// others.
	// Create a main method to test your methods.

	public void printByteBinary(byte b) {
		System.out.println(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1));
		System.out.println("======================================================");
	}

	public void printShortBinary(short s) {
		System.out.println(String.format("%016d", Integer.parseInt(Integer.toBinaryString(s))));
	}

	public void printIntBinary(int i) {
		System.out.println(Integer.toBinaryString(i));
	}

	public void printLongBinary(long l) {
		System.out.println(Long.toBinaryString(l));
	}

	public static void main(String[] args) {
		BinaryPrinter bp = new BinaryPrinter();
		bp.printByteBinary((byte) 129);
		bp.printShortBinary((short) 10);
	}
}
