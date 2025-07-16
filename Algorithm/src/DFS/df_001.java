package DFS;

import java.util.ArrayList;

public class df_001 {
	// 1
	// | \
	// 2--4
	// | /
	// 3
	// |
	// 5
	static ArrayList<Integer>[] graph = new ArrayList[6];

	public static void main(String[] args) {

		// 1~5노드로 이루어진 그래프, 0번은 안씀
		for (int i = 1; i <= 5; i++) {
			graph[i] = new ArrayList<>();
		}
		// 간선 추가
		graph[1].add(2); graph[1].add(3);
		graph[2].add(1); graph[2].add(4); graph[2].add(5);
		graph[3].add(1); graph[3].add(4);
		graph[4].add(2); graph[4].add(3);
		graph[5].add(2);

		dfs(1); //1-2-4-3-5
	}

	static boolean[] visited = new boolean[6];

	static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " "); // 방문한 노드 출력
		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

}
