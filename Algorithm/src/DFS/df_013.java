package DFS;

import java.util.ArrayList;

public class df_013 {

	static int count = 0;

	public static void main(String[] args) { // S가 해킹됐을때 영향을 받는 서버 수(본인 포함)
		int N = 7;
		int[][] connections = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 5 } };
		int S = 1;

		ArrayList<Integer>[] arr = new ArrayList[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < connections.length; i++) {
			arr[connections[i][0]].add(connections[i][1]);
			arr[connections[i][1]].add(connections[i][0]); // 양방향 필수
		}

		dfs(S, arr, visited);
		System.out.println(count);

	}

	private static void dfs(int now, ArrayList<Integer>[] arr, boolean[] visited) {
		visited[now] = true;
		count++;
		for(int next: arr[now]) {
			if(visited[next] == false) {
				dfs(next, arr, visited);
			}
		}
		
	}

}
