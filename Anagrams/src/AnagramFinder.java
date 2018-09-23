import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*	Suppose you have a dictionary of words design an algorithm that would scan all
 *  words and determine all words that are anagrams. 
 *  Your algorithm should be efficient and NOT O (n square)
 * 
 *  Build a hash of each word using prime numbers for each letter.
 *  Equal hashes means anagrams.
 * */

public class AnagramFinder {

	private final Map<Integer, List<String>> dictionary;
	private List<List<String>> anagrams = new ArrayList<>();

	public AnagramFinder(String[] dictionary) {
		this.dictionary = new HashMap<>();
		buildDictionary(dictionary);
	}

	/*
	 * Store calculated value and strings for that value
	 */
	private void buildDictionary(String[] dictionary) {
		for (String s : dictionary)
		{
			int value = getValue(s);
			List<String> list = this.dictionary.get(value);
			if (list == null)
			{
				list = new ArrayList<>();
			}
			list.add(s);
			this.dictionary.put(value, list);
		}
	}
	
	/*
	 * Any strings that are anagrams have the same value
	 * thus the same key and list is more than one
	 */
	public void printAnagrams()
	{
		StringBuilder builder = new StringBuilder();
		for (List<String> list : dictionary.values())
		{
			if (list.size() > 1)
			{
				for (String s : list)
				{
					builder.append(s);
					builder.append(",");
				}
				// Delete last comma
				builder.deleteCharAt(builder.length()-1);
				builder.append(" are anagrams\n");
			}
		}
		System.out.println(builder.toString());
	}

	public static void main(String[] args) {
		
		String[] dict = {
				"Test",
				"Haha",
				"Great",
				"Sett",
				"Ahha",
				"Treag",
				"Not"
		};
		
		AnagramFinder finder = new AnagramFinder(dict);
		finder.printAnagrams();
	}

	private static final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
			73, 79, 83, 89, 97, 101 };

	private int getValue(String s) {
		int value = 1;
		for (char c : s.toUpperCase().toCharArray()) {
			int i = (c-65);
			value *= primes[i];
		}

		return value;
	}
}
