package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class bf_004 {

	public static void main(String[] args) {
		int[][] grid = { // (n-1,m-1) 로 가는 최단 이동 칸 수. 0으로만 이동 상하좌우가능
	            {0, 0, 0},
	            {1, 1, 0},
	            {0, 0, 0}
	        };
		
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> que = new LinkedList<>();

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 예외처리
		if (n == 1 && m == 1) {
			System.out.println(0);
			return;
		}
		if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
			System.out.println(-1);
			return;
		}
		
		// 시작 세팅
		que.add(new int[] { 0, 0, 0 }); // x,y,거리
		visited[0][0] = true;

		// BFS
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			int d = temp[2];

			for (int di = 0; di < 4; di++) {
				int nx = x + dx[di];
				int ny = y + dy[di];

				// 건너뛰기
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (grid[nx][ny] == 1)
					continue;
				if (visited[nx][ny])
					continue;

				// 도착이면 즉시 종료
				if (x == n - 1 && y == m - 1) {
					System.out.println(d);
					return;
				}

				visited[nx][ny] = true;
				que.add(new int[] { nx, ny, d + 1 });
			}
		}
		
		System.out.println(-1);

	}

}
