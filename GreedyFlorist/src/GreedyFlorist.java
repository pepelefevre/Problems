import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GreedyFlorist {

	// Complete the getMinimumCost function below.
	static int getMinimumCost(int k, int[] c) {

		int cost = 0;

		// More friends than flowers, just buy one of each
		if (k >= c.length) {
			for (int i = 0; i < c.length; ++i) {
				cost += c[i];
			}
		} else {
			// Else sort array and always buy most expensive first
			Queue q = new PriorityQueue<Integer>(c.length, Collections.reverseOrder());
			for (int i = 0; i < c.length; ++i) {
				q.add(c[i]);
			}

			// Keep track of purchases for each friend
			int[] purchases = new int[k];

			while (!q.isEmpty()) {
				// Each friend should buy in order
				for (int i = 0; i < k; ++i) {
					if (q.isEmpty())
						break;
					cost += costOfFlower(purchases[i]++, (int) q.poll());
				}
			}
		}

		return cost;

	}

	static int costOfFlower(int purchases, int originalCost) {
		return (1 + purchases) * originalCost;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println(getMinimumCost(2, new int[] {2,5,6}));
	}
}
