package DFS;

import java.util.ArrayList;

public class df_016 {
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) { // 단방향 s부터t까지 가장 짧은 경로 리턴. 없으면-1
		int N = 5;
		int[][] transfers = { { 0, 1 }, { 1, 2 }, { 0, 2 }, { 2, 3 }, { 3, 4 } };
		int S = 0, T = 4;

		boolean[] visited = new boolean[N];
		ArrayList<Integer>[] arr = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < transfers.length; i++) {
			arr[transfers[i][0]].add(transfers[i][1]);
		}
		int count = 0;
		dfs(S, T, visited, arr, count);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	private static void dfs(int s, int t, boolean[] visited, ArrayList<Integer>[] arr, int count) {

		if (s == t) {
			if (count < answer) {
				answer = count;
				// count = 0; 각각 재귀마다 다른 count 세고있어서 필요없음
				// answer = Math.min(answer, count);
				return; // 추가!
			}
		}
		visited[s] = true;
		for (int next : arr[s]) {
			if (visited[next] == false) {
				dfs(next, t, visited, arr, count + 1);
			}
		}
		visited[s] = false;

	}

}
