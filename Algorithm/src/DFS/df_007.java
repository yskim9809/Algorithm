package DFS;

public class df_007 {
	static int count = 0;

	public static void main(String[] args) { // 부분집합의 합이 s가 되는 개수
		int[] arr = { 2, 4, 6, 8 };
		int S = 8;
		dfs(0, 0, 0, arr, S);
		System.out.println(count);

	}

	private static void dfs(int idx, int sum, int picked, int[] arr, int S) {
		if (idx == arr.length) {
			if (picked > 0 && sum == S) {
				count++;
			}
			return;
		}

		dfs(idx + 1, sum + arr[idx], picked + 1, arr, S); // 현재 원소 포함
		dfs(idx + 1, sum, picked, arr, S); // 현재 원소 미포함

	}
}
