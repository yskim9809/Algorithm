package DFS;

public class df_004 {

	public static void main(String[] args) { //단지 개수 구하기
		int[][] maps = {  
			    {1, 1, 0, 0},
			    {1, 0, 0, 1},
			    {0, 0, 1, 1},
			    {0, 1, 0, 0}
			};

			int n = maps.length;
			int m = maps[0].length;
			boolean[][] visited = new boolean[n][m];

			int count = 0;

			int[] dx = { 0, 0, -1, 1 }; // x가 행 아래로, y가 열 오른쪽으로 {1,2,3}
			int[] dy = { 1, -1, 0, 0 }; // 오른쪽, 왼쪽, 위, 아래 {4,5,6}
										// {7,8,9}

			// 이중 for문으로 모든 칸 돌면서 1인 곳 visited = false 인곳 찾기
			for (int i = 0; i < maps.length; i++) {
				for (int j = 0; j < maps[0].length; j++) {
					if (maps[i][j] == 1 && visited[i][j] == false) {
						// 이런 곳을 찾으면 dfs 시작, 그 칸과 연결된 모든 1을 true로 바꾸기, count++
						dfs(i, j, maps, visited, n, m, dx, dy);
						count++;

					}
				}
			}
			System.out.println(count);

		}

		private static void dfs(int i, int j, int[][] maps, boolean[][] visited, int n, int m, int[] dx, int[] dy) {
			visited[i][j] = true;
			for (int d = 0; d < 4; d++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (maps[nx][ny] == 1 && visited[nx][ny] == false) {
						dfs(nx, ny, maps, visited, n, m, dx, dy);
					}
				}
			}

		}

	}
