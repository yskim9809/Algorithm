package DFS;

import java.util.ArrayList;

public class df_014 {
	static int count = 0;

	public static void main(String[] args) { // s에서 t까지 닿을 수 있는 경로의 수, 단방향
		int N = 4;
		int[][] transfers = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
		int S = 0, T = 3;

		boolean[] visited = new boolean[N];
		ArrayList<Integer>[] arr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < transfers.length; i++) {
			arr[transfers[i][0]].add(transfers[i][1]);
		}

		dfs(S, T, arr, visited);

		System.out.println(count);

	}

	private static void dfs(int now, int t, ArrayList<Integer>[] arr, boolean[] visited) {
		visited[now] = true;
		if (now == t) {
			count++;
		}
		for (int next : arr[now]) {
			if (!visited[next]) {
				dfs(next, t, arr, visited);
			}
		}

		visited[now] = false;

	}

}
