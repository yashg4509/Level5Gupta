package _04_00_Binary_Conversion;

import java.util.ArrayList;
import java.util.List;

public class DecimalToBinary {

	public DecimalToBinary() {

	}

	public static void main(String[] args) {
		// Converting a decimal number to binary is a little trickier.
		DecimalToBinary db = new DecimalToBinary();
		// EXAMPLE: Convert 43 to binary
		System.out.println(db.convert(43));

		/*
		 * Step 1: Start with one and add a digit the left that is double the value of
		 * the previous number. Stop when you've passed the target number eg. 43 64 32
		 * 16 8 4 2 1
		 * 
		 * Step 2: Remove the left most value (the one that is higher than the target).
		 * eg. 43 32 16 8 4 2 1
		 * 
		 * Step 3: Find the combination of values that add up to the target number. eg.
		 * 43 32 16 8 4 2 1 43 = 32 + 8 + 2 + 1
		 * 
		 * Step 4: Every matching number in the list is a 1, and non-matching is a 0.
		 * eg. 43 32 16 8 4 2 1 43 = 32 + 8 + 2 + 1
		 * 
		 * 1 0 1 0 1 1 32 16 8 4 2 1
		 * 
		 * 43 in decimal is 101011 in binary!
		 */
	}

	private String convert(int t) {
		List<Integer> l = build(t);
		List<Integer> result = find(t, l, 0);
		System.out.println(result);
		return "";
	}

	private List<Integer> find(int t, List<Integer> l, int i) {
		if (i >= l.size()) {
			if (t == count(l)) {
				return l;
			} else {
				return null;
			}
		}
		List<Integer> list = find(t, l, i + 1);

		if (list != null) {
			return list;
		}

		int removed = l.remove(i);
		list = find(t, l, i + 1);
		if (list != null)
			l.add(i, removed);
		return list;
	}

	private int count(List<Integer> l) {
		int sum = 0;

		for (int i = 0; i < l.size(); i++) {
			sum += l.get(i);
		}

		return sum;
	}

	private List<Integer> build(int t) {
		int i = 1;

		List<Integer> vals = new ArrayList<>();
		while (i <= t) {
			vals.add(i);
			i *= 2;
		}

		return vals;

	}
}
