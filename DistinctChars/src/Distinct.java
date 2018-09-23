import java.util.Set;
import java.util.HashSet;

/*Given an integer k and a string s, find the length of the longest substring 
 * that contains at most k distinct characters.
 * For example, given s = "abcba" and k = 2, the longest substring with k
 *  distinct characters is "bcb".*/
public class Distinct {

	public static int distinctChars(String s, int K) {
		int[] chars = new int[s.length()];
		int dis = _distinct(s, K, 0, chars);
		for (int i : chars) {
			System.out.print(i + " ");
		}
		System.out.println();
		return dis;
	}

	private static int _distinct(String s, int k, int i, int[] chars) {
		if (i >= s.length() - 1)
			return 0;

		System.out.print(i);

		// Store already used chars
		Set<Character> used = new HashSet<Character>(k);

		int length = 0;
		used.add(s.charAt(i));
		// Get every one of the first letter and save the position after that
		if (chars[i] == 0)
			chars[i] = getNumChars(s, i);

		length = chars[i];
		i += length;

		int j = i;
		// Get up to k-1 of the next distinct chars
		for (int c = 1; i < s.length() && c < k;) {

			used.add(s.charAt(i));

			if (chars[i] == 0)
				chars[i] = getNumChars(s, i);
			// Add this character
			length += chars[i];
			// Goto the next character
			i += chars[i];

			// Next character doesn't count if not distinct
			if (i < s.length() && !used.contains(s.charAt(i)))
				c++;
		}

		System.out.println(" " + length);

		// Return the max of including s[i] or skipping it
		return Math.max(length, _distinct(s, k, j, chars));

	}

	// Get the number of same character elements starting at element i
	private static int getNumChars(String s, int i) {
		if (i >= s.length())
			return 0;
		int num = 1;
		for (int j = i + 1; j < s.length() && s.charAt(i) == s.charAt(j); j++) {
			num++;
		}
		return num;
	}

	public static void main(String[] args) {

		String s = "abbbbaabcccbbaccc";
		System.out.println(distinctChars(s, 2));
	}

}
