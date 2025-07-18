package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class df_002 {
	static Scanner scanner = new Scanner(System.in);
	static int n = scanner.nextInt();
	static ArrayList<Integer>[] graph = new ArrayList[n + 1];

	public static void main(String[] args) {
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		int m = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < m; i++) {
			String[] st = scanner.nextLine().split(" ");
			int a = Integer.parseInt(st[0]);
			int b = Integer.parseInt(st[1]);
			graph[a].add(b);
			graph[b].add(a); // 반드시 양방향 추가
		}
		dfs(1);
		System.out.println(count-1);
	}

	static boolean[] visited = new boolean[n + 1];
	static int count = 0;

	private static void dfs(int node) {
		visited[node] = true;
		count++;
		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

}
