package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class bf_005 {

	public static void main(String[] args) { //그림의 갯수와 가장 큰 그림의 넓이
		int[][] grid = {
			    {1, 1, 0, 0, 0},
			    {1, 1, 0, 1, 1},
			    {0, 0, 0, 1, 1},
			    {0, 0, 0, 0, 0}
			};
		
			int n = grid.length;
			int m = grid[0].length;
			boolean[][] visited = new boolean[n][m];

			Queue<int[]> que = new LinkedList<>();

			int[] dx = { 0, 0, -1, 1 };
			int[] dy = { 1, -1, 0, 0 };

			int count = 0; // 그림갯수
			int maxarea = 0;// 가장넓은그림크기
			
			// 전 칸을 돌면서 새 그림 시작 지점 찾기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 새 그림 발견 - > BFS시작
					if (grid[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						que.add(new int[] { i, j });
						int area = 0;

						// BFS로 넓이 구하기
						while (!que.isEmpty()) {
							int[] temp = que.poll();
							int x = temp[0];
							int y = temp[1];
							area++;

							for (int dir = 0; dir < 4; dir++) {
								int nx = x + dx[dir];
								int ny = y + dy[dir];

								if (nx < 0 || ny < 0 || nx >= n || ny >= m)
									continue;
								if (visited[nx][ny]) //이미 방문한 칸 스킵
									continue;
								if (grid[nx][ny] == 0) //그림이 아닌곳 스킵
									continue;

								visited[nx][ny] = true;
								que.add(new int[] { nx, ny });

							}
						}
						count++;
						if (area > maxarea) {
							maxarea = area;
						}

					}
				}
			}
			
			System.out.println("그림 수: " + count);
			System.out.println("가장 큰 그림 크기: " + maxarea);
		

	}

}
