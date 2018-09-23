import java.util.ArrayDeque;
import java.util.Queue;

public class ArraySearch {

	public static void main(String[] args) {

		int[][] arr = { { 1, 13, 14, 16 }, { 2, 14, 15, 18 }, { 4, 16, 17, 20 }, { 7, 18, 19, 21 } };

		System.out.println(DFS(arr, 19));
		System.out.println(BFS(arr, 19));
	}

	static boolean DFS(int[][] arr, int num) {
		return DFsearch(arr, 0, 0, num);
	}
	
	static boolean DFsearch(int [][] arr, int i, int j, int num)
	{
		if (i >= arr.length || j >= arr[0].length)
			return false;
		if (arr[i][j] == num)
			return true;
		if (arr[i][j] > num)
			return false;
		if (DFsearch(arr, i+1, j, num))
			return true;
		if (DFsearch(arr, i, j+1, num))
			return true;
		return false;
	}
	
	static boolean BFS(int[][] arr, int num)
	{
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{0,0});
		
		while (!queue.isEmpty())
		{
			int[] i = queue.poll();
			
			if (i[0] >= arr.length || i[1] >= arr[0].length)
				continue;
			int n = arr[i[0]][i[1]];
			if (n == num)
				return true;
			if (n > num)
				continue;
			queue.add(new int[] {i[0]+1, i[1]});
			queue.add(new int[] {i[0], i[1]+1});
		}
		
		return false;
	}

}
