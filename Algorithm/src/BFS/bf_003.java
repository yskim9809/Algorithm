package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class bf_003 {

	public static void main(String[] args) { // t까지 도달할 수 있는 최소 횟수 오름차순, 없으면 -1
		int N = 5;
		int[][] transfers = { { 0, 1 }, { 1, 2 }, { 2, 4 }, { 0, 3 }, { 3, 4 } };
		int T = 4;

		boolean[] visited = new boolean[N];
		Queue<int[]> que = new LinkedList<>();
		ArrayList<Integer>[] arr = new ArrayList[N];
		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < transfers.length; i++) {
			arr[transfers[i][0]].add(transfers[i][1]);
		}

		que.add(new int[] { 0, 0 }); // 시작점, 이동횟수
		visited[0] = true; // 시작점

		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int now = temp[0];
			int dist = temp[1];

			if (now == T) {
				answer.add(dist);
			}

			for (int next : arr[now]) {
				if (!visited[next]) {
					visited[next] = true;
					que.add(new int[] { next, dist + 1 });
				}
			}
		}
		
		if(answer.size()>0) {
			Collections.sort(answer);
			for(int i=0; i<answer.size(); i++) {
				System.out.print(answer.get(i)+" ");
			}
		}else {
			System.out.println(-1);
		}
		

	}

}
