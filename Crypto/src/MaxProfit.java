import java.util.Random;

public class MaxProfit {
	
	private static int stupidProfit(int[] prices, int size)
	{
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < size; ++j)
			{
				maxProfit = Math.max(maxProfit, prices[i] - prices[j]);
			}
		}
		
		return maxProfit;
	}
	
	private static int maxProfit(int[] prices, int size)
	{
		int maxProfit = Integer.MIN_VALUE;
		
		for (int i = 1; i < size; ++i)
		{
			for (int j = 0; j < i; ++j)
			{
				maxProfit = Math.max(maxProfit, prices[i] - prices[j]);
			}
		}
		
		return maxProfit;
	}
	
	private static int maxProfitJeff(int[] prices, int size)
	{
		return maxProfit(prices, 0, size - 1);
	}
	
	private static int maxProfit(int[] a, int l, int r)
	{
		if (l == r)
			return 0;
		
		int max = 0;
		
		// index of maximum
		int mi = l+1;
		int m1 = a[l+1];
		int l1 = a[l];
		
		// Get the maximum value
		for (int i = l+1; i <= r; ++i)
		{
			if (Math.max(m1, a[i]) != m1)
			{
				// Update index and max
				m1 = a[i];
				mi = i;
			}
		}
		// and minimum value to the left of max
		for (int i = 0; i < mi; ++i)
		{
			l1 = Math.min(l1, a[i]);
		}
		
		// Maximum profit when selling at the max
		max = Math.max(max, m1 - l1);
		
		// If there's no more to the right to check
		if (mi == r)
			return max;
		
		// Otherwise, check to the right of max
		return Math.max(max, maxProfit(a, mi + 1, r));
	}
	
	public static void main(String[] args)
	{
		int size = 100000;
		int[] prices = new int[size];
		
		Random rnd = new Random();
		prices[0] = rnd.nextInt(100) + 1;
		for (int i = 1; i < size; ++i)
		{
			if (rnd.nextInt(100) + 1 < 50)
			{
				prices[i] = Math.max(0,prices[i-1] - (rnd.nextInt(25) + 2));
			}
			else
			{
				prices[i] += (rnd.nextInt(25) + 2);
			}
		}
		
		long startTime = System.currentTimeMillis();
		int maxS = maxProfit(prices, prices.length);
		long endTime = System.currentTimeMillis();
		long timeS = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		int maxP = maxProfit(prices, prices.length);
		endTime = System.currentTimeMillis();
		long timeP = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		int maxJ = maxProfitJeff(prices, prices.length);
		endTime = System.currentTimeMillis();
		long timeJ = endTime - startTime;
		
		if (maxP != maxJ || timeJ > timeP)
		{
			System.out.println("JEFF SUCKS");
		}
		else if (timeJ < timeP)
		{
			System.out.println("JEFF DOES NOT SUCK");
		}
		else
		{
			System.out.println("UNABLE TO DETERMINE SUCKINESS OF JEFF");
		}
		
		System.out.println("N: " + size);
		System.out.println("Max Profit: " + maxJ);
		System.out.println("Stupid Time: " + timeS + "ms");
		System.out.println("My Time: " + timeP + "ms");
		System.out.println("Jeff's Time: " + timeJ + "ms");
	}
}
