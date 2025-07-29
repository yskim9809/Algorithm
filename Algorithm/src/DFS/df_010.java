package DFS;

import java.util.ArrayList;
import java.util.Collections;

public class df_010 {

	public static void main(String[] args) { //영역의 칸 수 오름차순 정렬
		int[][] maps = {
			    {0,2,0,2,2},
			    {2,2,0,0,2},
			    {0,0,0,2,2},
			    {2,0,0,0,0}
			};
		
			int n = maps.length;
			int m = maps[0].length;
			boolean[][] visited = new boolean[n][m];
			ArrayList<Integer> arr = new ArrayList<>();
			int[] dx = { 0, 0, -1, 1 };
			int[] dy = { 1, -1, 0, 0 };
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && maps[i][j] == 2) {
					int count = dfs(i, j, n, m, visited, dx, dy, maps);
					arr.add(count);
				}
			}
		}
		if (arr.isEmpty()) {
		    System.out.println("[-1]");
		} else {
		    Collections.sort(arr);
		    System.out.println(arr);
		}

	}

	private static int dfs(int i, int j, int n, int m, boolean[][] visited, int[] dx, int[] dy, int[][] maps) {
		visited[i][j] = true;
		int count = 1;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (!visited[nx][ny] && maps[nx][ny] == 2) {
					count += dfs(nx, ny, n, m, visited, dx, dy, maps);
				}
			}
		}
		return count;
	}

}
