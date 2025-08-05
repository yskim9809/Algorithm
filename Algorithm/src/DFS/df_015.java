package DFS;

import java.util.ArrayList;

public class df_015 {
	static boolean cycle = false;

	public static void main(String[] args) { // 단방향 계좌들끼리 사이클이 있는지 확인 t/f
		int N = 4;
		int[][] transfers = { { 0, 1 }, { 1, 2 }, { 2, 3 } };

		boolean[] visited = new boolean[N];
		ArrayList<Integer>[] arr = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < transfers.length; i++) {
			arr[transfers[i][0]].add(transfers[i][1]);
		}

		for (int i = 0; i < N; i++) { //모든 모드에서 사이클이 있는지 확인
			dfs(i, visited, arr);
			if (cycle == true)
				break;
		}

		System.out.println(cycle);

	}

	private static void dfs(int i, boolean[] visited, ArrayList<Integer>[] arr) {
		if (cycle == true)
			return;

		visited[i] = true;
		for (int next : arr[i]) {
			if (!visited[next]) {
				dfs(next, visited, arr);
			} else {
				cycle = true;
				return;
			}
		}
		visited[i] = false;

	}

}
