package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bf_002 {

	public static void main(String[] args) { // 0번노드에서 3번노드까지 최소 몇번만에 갈수있을까
		int N = 4;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 2 } };

		Queue<int[]> que = new LinkedList<>();
		ArrayList<Integer>[] arr = new ArrayList[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) {
			arr[edges[i][0]].add(edges[i][1]);
		}

		que.add(new int[] { 0, 0 }); // 시작점 : 현재노드, 이동횟수
		visited[0] = true; // 시작점

		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int now = temp[0];
			int dist = temp[1];

			if (now == 3) {
				System.out.println(dist);
				return;
			}
			for (int next : arr[now]) {
				if (!visited[next]) {
					visited[next] = true;
					que.add(new int[] { next, dist + 1 }); // que에 노드번호와 지금까지 이동한 거리를 함께 저장
				}
			}
		}
		System.out.println(-1); // 도달불가시

	}

}
