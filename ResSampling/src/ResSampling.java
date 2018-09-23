import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class ResSampling<T> {

	private final T[] reservoir;

	public ResSampling(T[] reservoir) {
		this.reservoir = reservoir;
	}

	public List<T> sample(int x) {
		List<T> sampleList = new ArrayList<>(x);
		Random rnd = new Random();

		int i = 1;
		// Loop through reservoir (stream)
		for (T obj : reservoir) {
			// Pick a number between (0,i] where i is number in the reservoir.
			int r = rnd.nextInt(i);
			// If that number is in the range of (0,x],
			// then we keep that object in our sample... for now (odds x/i)
			if (r >= 0 && r <= x - 1) {
				// Replace the old obj with this one
				// Odds of obj being replaced = (x/i-1) - (x/i * 1/x * x/i-1)
				if (sampleList.size() < x)
					sampleList.add(obj);
				else
					sampleList.set(r, obj);
			}
			// Else we just toss it out and on to the next one
			i++;
		}

		return sampleList;
	}

	public static void main(String[] args) {

		int n = 100;
		Integer[] arr = new Integer[n];
		int[] results = new int[n];
		for (int i = 0; i < n; ++i)
		{
			arr[i] = i+1;
		}
		
		ResSampling<Integer> sampler = new ResSampling(arr);
		int m = 1000000;
		int x = 10;
		for (int i = 0; i < m; i++)
		{
			for (Integer sample : sampler.sample(x))
			{
				results[sample-1]++;
			}
		}
		
		double varience = 0;
		double stdDev = 0;
		for (int i = 0; i < n; ++i)
		{
			double d = (m/x-results[i]);
			System.out.println(d/m*100);
		}
		
	}

}
