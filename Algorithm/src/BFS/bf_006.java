package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bf_006 {

	public static void main(String[] args) {
		int[][] graph = { { 0, 1 }, { 1, 2 }, { 2, 4 }, { 0, 3 }, { 3, 4 } };
		int n = 5; // 정점 수
		int start = 2;
		int p = 3; // p번 노드까지 최단거리 구하기

		Queue<int[]> que = new LinkedList<>();
		boolean[] visited = new boolean[n];
		List<Integer>[] list = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < graph.length; i++) {
			list[graph[i][0]].add(graph[i][1]);
			list[graph[i][1]].add(graph[i][0]); // 양방향일때
		}

		que.add(new int[] { start, 0 }); // 시작점, 이동횟수
		visited[start] = true;

		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int x = temp[0];
			int d = temp[1];

			if (x == p) {
				System.out.println(d);
				return;
			}

			for (int next : list[x]) {
				if (!visited[next]) {
					visited[next] = true;
					que.add(new int[] { next, d + 1 });
				}
			}

		}
		System.out.println(-1); // 도달 불가일 때

	}

}
