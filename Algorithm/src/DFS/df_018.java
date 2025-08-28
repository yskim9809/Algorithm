package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class df_018 { // 백준 2606 바이러스

	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim()); // 컴퓨터 수
		int m = Integer.parseInt(br.readLine().trim()); // 간선 수

		List<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		// 여기서부터 문제 풀이 로직 작성
		boolean[] visited = new boolean[n+1]; //컴퓨터번호 1번부터시작
		dfs(graph, visited, 1);
		System.out.println(count-1); //1번도 방문한걸로 세어짐

	}

	private static void dfs(List<Integer>[] graph, boolean[] visited, int start) {
		visited[start] = true;
		count++;
		for (int next : graph[start]) {
			if (!visited[next]) {
				dfs(graph, visited, next);
			}
		}
	}

}
