
public class Search2D {

	/*
	 * Search in a row wise and column wise sorted matrix Given an n x n matrix and
	 * a number x, find the position of x in the matrix if it is present in it.
	 * Otherwise, print “Not Found”. In the given matrix, every row and column is
	 * sorted in increasing order. The designed algorithm should have linear time
	 * complexity.
	 * 
	 * Example :
	 * 
	 * Input : mat[4][4] = { {10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48},
	 * {32, 33, 39, 50}}; x = 29 Output : Found at (2, 1)
	 * 
	 * Input : mat[4][4] = { {10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48},
	 * {32, 33, 39, 50}}; x = 100 Output : Element not found
	 * 
	 */
	public static void searchArr(int[][] arr, int x) {
		if (!search(arr, 0, 0, arr.length - 1, arr.length - 1, x))
			System.out.println("Element not found");
	}

	private static boolean search(int[][] a, int r1, int c1, int r2, int c2, int x) {
		if (a[r1][c1] == x) {
			System.out.println("(" + r1 + "," + c1 + ")");
			return true;
		}
		if (a[r2][c2] == x) {
			System.out.println("(" + r2 + "," + c2 + ")");
			return true;
		}
		if (x > a[r2][c2] || x < a[r1][c1])
			return false;
		if (r1 == r2 - 1 && c1 == c2 - 1) { // 2x2, just check
			if (x == a[r1][c2]) {
				System.out.println("(" + r1 + "," + c2 + ")");
				return true;
			}
			if (x == a[r2][c1]) {
				System.out.println("(" + r2 + "," + c1 + ")");
				return true;
			}
		}
		// Divide into 4ths
		return (search(a, r1, c1, r2 / 2, c2 / 2, x) || search(a, r1, c2 / 2 + 1, r2 / 2, c2, x)
				|| search(a, r2 / 2 + 1, c1, r2, c2 / 2, x) || search(a, r2 / 2 + 1, c2 / 2 + 1, r2, c2, x));

	}

	public static void main(String[] args) {
		int[][] mat = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		searchArr(mat, 29);
		searchArr(mat, 100);
	}

}
