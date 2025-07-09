package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class hs_002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Integer> cmap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		for (int num : arr) {
			cmap.put(num, cmap.getOrDefault(num, 0) + 1);
		}
		int m = scanner.nextInt();
		// int[] arr2 = new int[m];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int card = scanner.nextInt();
			sb.append(cmap.getOrDefault(card, 0) + " ");
		}
		System.out.print(sb);

	}

}
