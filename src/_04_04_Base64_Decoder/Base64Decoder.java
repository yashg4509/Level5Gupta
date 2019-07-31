package _04_04_Base64_Decoder;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being
	 * converted do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML
	 * file (for web development), so that way a web site does not have to look for
	 * an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */

	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	// 1. Complete this method so that it returns the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		byte result = -1;

		for (int i = 0; i < base64Chars.length; i++) {
			if (base64Chars[i] == c) {
				result = (byte) i;
				break;
			}
		}

		return result;
	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		byte[] res = new byte[3];

		char[] charr = s.toCharArray();

		res[0] = (byte) (convertBase64Char(charr[0]) << 2 | convertBase64Char(charr[1]) >> 4);
		res[1] = (byte) (convertBase64Char(charr[1]) << 4 | convertBase64Char(charr[2]) >> 2);
		res[2] = (byte) (((convertBase64Char(charr[2]) << 6) & 0xc0) | convertBase64Char(charr[3]));

		return res;

	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		System.out.println(file.length());
		int arrLength = ((file.length() / 4) + (file.length() % 4 == 0 ? 0 : 4)) * 3;
		byte[] arr = new byte[arrLength];
		String input = "";

		for (int i = 0; i < file.length(); i += 4) {
			input = file.substring(i, i + 4);
			byte[] smallarr = convert4CharsTo24Bits(input);
			for (int j = 0; j < smallarr.length; j++) {
				arr[(smallarr.length * (i / 4)) + j] = smallarr[j];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		return arr;

	}
}
