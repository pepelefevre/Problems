import java.util.Arrays;

public class Kadane {

	public static int Kadane(int[] arr)
	{
		if (arr.length == 1)
			return arr[0];
		int max = Math.max(arr[0] + Kadane(Arrays.copyOfRange(arr, 1, arr.length)), arr[0]);
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("MAX: " + max);
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(Kadane(new int[] {10,8,-12,5,-9,100}));
	}

}
