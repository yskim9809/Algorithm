package DFS;

import java.util.ArrayList;
import java.util.Collections;

public class df_017 {
	static ArrayList<Integer> answer = new ArrayList<>();

	public static void main(String[] args) { // T로 도달 가능한 출발점들 오름차순 배열
		int N = 5;
		int[][] transfers = { { 0, 1 }, { 1, 2 }, { 2, 4 }, { 0, 3 }, { 3, 4 } };
		int T = 4;

		// boolean[] visited = new boolean[N];
		ArrayList<Integer>[] arr = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < transfers.length; i++) {
			arr[transfers[i][0]].add(transfers[i][1]);
		}
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N]; // for문 안에 visited 새로 선언
			int start = i;
			dfs(start, i, T, visited, arr);
		}

		Collections.sort(answer);
		System.out.println(answer.toString());

	}

	private static void dfs(int start, int now, int t, boolean[] visited, ArrayList<Integer>[] arr) {
		if (now == t) {
			if (!answer.contains(start)) // 중복방지 아니면 hashset 쓰기
				answer.add(start);
			return;
		}
		visited[now] = true;
		for (int next : arr[now]) {
			if (!visited[next]) {
				dfs(start, next, t, visited, arr);
			}
		}
		// visited[now] = false; for 문안에 visited 선언해서 필요없듬

	}

}
