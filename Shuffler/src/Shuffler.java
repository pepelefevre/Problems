import java.util.Random;

public class Shuffler {

	public static void main(String[] args) {
		
		int count = 12;
		
		int[] arr = new int[count];
		
		for (int i = 0; i < count; ++i)
		{
			arr[i] = i + 1;
		}
		
		shuffle(arr);
		
		for (int i = 0; i < count; ++i)
		{
			System.out.print(arr[i] + " ");
		}

	}
	
	static void shuffle(int[] arr)
	{
		Random random = new Random();
		for (int i = arr.length - 1; i > 0; --i)
		{
			// Starting with whole deck, get random index
			// then "remove" that index and get random of one less size.
			// "Removing" the card from the random is done by moving it 
			// to the max index which shrinks after each random
			int rnd = random.nextInt(i);
			swap(arr, rnd, i);
		}
	}

	static void swap(int[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
