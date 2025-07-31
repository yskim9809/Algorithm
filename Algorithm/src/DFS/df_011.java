package DFS;

import java.util.ArrayList;

public class df_011 {

	private static int count;

	public static void main(String[] args) {
		//0번 정점에서 N-1번 정점까지 방문한 적 없는 정점만 방문하며
		//갈 수 있는 모든 경로의 개수를 DFS로 구하라
		int N = 4;
		int[][] edges = {
		    {0,1},
		    {0,2},
		    {1,2},
		    {2,3}
		};

		ArrayList<Integer>[] arr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			arr[edge[0]].add(edge[1]);
		}

		boolean[] visited = new boolean[N];
		dfs(0, N - 1, visited, arr);
		
		System.out.println(count);
		

	}

	private static void dfs(int i, int j, boolean[] visited, ArrayList<Integer>[] arr) {
		if (i == j) {
			count++;
			return;
		}
		visited[i] = true; // now
		for (int next : arr[i]) {
			if (!visited[next]) {
				dfs(next, j, visited, arr);
			}
		}
		visited[i] = false;

	}

}
