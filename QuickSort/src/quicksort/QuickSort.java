package quicksort;

public class QuickSort {

	static int count;
	
	public static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	private static void quicksort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int index = partition(arr, left, right);

//		if (count++ > 4)
//			System.exit(0);
		
		quicksort(arr, left, index - 1);
		quicksort(arr, index + 1, right);
	}

	private static int partition(int[] arr, int left, int right) {
		int index = (left + right) / 2;
		int pivot = arr[index];

		while (left < right) {
			while (arr[left] <= pivot && left < right) {
				left++;
			}

			while (arr[right] >= pivot && left < right) {
				right--;
			}

			// Swap right and left
			if (left < right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}

		if (index > right && arr[index] < arr[right])
		{
			swap(arr, index, right);
			return right;
		}
		
		if (index < left && arr[index] > arr[left])
		{
			swap(arr, index, left);
			return left;
		}
		return right;
	}

	private static void swap(int[] arr, int left, int right) {
		
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
			
	}

	public static void main(String[] args) {
		int[] array = { 11, 16, 2, 7, 9, 24, 10 };

		count = 0;
		
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println();

		quicksort(array);

		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println();

	}

}
