
public class Staircase {
	
	public static int staircase(int n, int[] s)
	{
		if (n <= 0)
			return 0;
		int[] memo = new int[n+1];
		return _staircase(n, s, memo);
	}
	
	private static int _staircase(int n, int[] s, int[] memo)
	{	
		int result = 0;
		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;
		else if (memo[n] != 0)
			return memo[n];
		else
		{
			for (int i : s)
			{
				result += _staircase(n-i, s, memo);
			}
		}
		
		memo[n] = result;
		return result;
			
	}
	
	public static void main(String[] args) {
		
		System.out.println(staircase(2, new int[] {1,2}));
		System.out.println(staircase(5, new int[] {1,2}));

	}

}
