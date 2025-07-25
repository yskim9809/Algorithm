package DFS;

public class df_006 {
	static int totalpaths =0;
	public static void main(String[] args) { //목적지까지 가는 경로의 수
		int[][] maps = {
				  {1, 1, 0},
				  {0, 1, 1},
				  {1, 1, 1}
				};
		int n = maps.length;
		int m = maps[0].length;
		boolean[][] visited = new boolean[n][m];
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0}; //오, 왼, 아래, 위
		
		dfs(0,0,maps,visited,n,m,dx,dy); //시작점
		System.out.println(totalpaths);
	}

	private static void dfs(int i, int j, int[][] maps, boolean[][] visited, int n, int m, int[] dx, int[] dy) {
		if (i == n - 1 && j == m - 1) { //목적지 도달
			totalpaths++;
			return;
		}
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (maps[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny, maps, visited, n, m, dx, dy);
				}
			}
		}
		visited[i][j]=false; //방문체크 원상복구

	}

}
