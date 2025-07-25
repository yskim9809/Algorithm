package DFS;

import java.util.ArrayList;
import java.util.Collections;

public class df_005 {

	public static void main(String[] args) { //각 단지의 집 수 오름차순
		int[][] maps = {
			    {0, 1, 1, 0},
			    {1, 1, 0, 0},
			    {0, 0, 1, 1},
			    {0, 1, 1, 0}
			};
			int n = maps.length;
			int m = maps[0].length;
			boolean[][] visited = new boolean[n][m];
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 }; // 위, 아래, 왼, 오
			ArrayList<Integer> arr = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (maps[i][j] == 1 && !visited[i][j]) {

						int count = dfs(i, j, maps, visited, n, m, dx, dy);
						arr.add(count);
					}
				}
			}
			Collections.sort(arr);
			System.out.println(arr);

		}

		private static int dfs(int i, int j, int[][] maps, boolean[][] visited, int n, int m, int[] dx, int[] dy) {
			visited[i][j] = true;
			int count = 1;
			for (int d = 0; d < 4; d++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (maps[nx][ny] == 1 && !visited[nx][ny]) {
						count += dfs(nx, ny, maps, visited, n, m, dx, dy);
					}
				}
			}
			return count;

		}

}
