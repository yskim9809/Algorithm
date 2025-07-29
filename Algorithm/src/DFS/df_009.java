package DFS;

public class df_009 {

	public static void main(String[] args) { //목적지 도달 시 경로의 합이 특정 값이 되는 모든 경우의 수 (상하좌우)
		int[][] maps = {
			    {1, 1, 1},
			    {2, 2, 2},
			    {1, 1, 1}
			};
		int S = 7;
		
		int n = maps.length;
		int m = maps[0].length;
		boolean[][] visited = new boolean[n][m];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int count = dfs(0, 0, n, m, visited, dx, dy, maps[0][0], maps, S);
		System.out.println(count);
	}

	private static int dfs(int i, int j, int n, int m, boolean[][] visited, int[] dx, int[] dy, int sum, int[][] maps,
			int S) {
		
		if (i == n - 1 && j == m - 1) {
			if (sum == S) {
				return 1;
			} else {
				return 0;
			}
		}
		visited[i][j]=true;
		int count = 0;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
				count += dfs(nx, ny, n, m, visited, dx, dy, sum + maps[nx][ny], maps, S);
			}
		}
		visited[i][j]=false;
		return count;

	}

}
