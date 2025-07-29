package DFS;

public class df_008 {

	public static void main(String[] args) { //목적지 도달 시 경로의 합이 특정 값이 되는 모든 경우의 수
											 //(오른쪽 아래로만 이동가능)
		int[][] maps = {
			    {1, 2, 3},
			    {4, 5, 6},
			    {7, 8, 9}
			};
		int S = 21;
		
		int n = maps.length;
		int m = maps[0].length;
		int[] dx = { 1,0 };
		int[] dy = { 0,1 }; //오른쪽, 아래로만 이동

		int count = dfs(0,0, n, m, dx, dy, maps[0][0], maps, S);
		System.out.println(count);

	}

	private static int dfs(int i, int j, int n, int m, int[] dx, int[] dy, int sum, int[][] maps, int S) {
		if (i == n - 1 && j == m - 1) {
			if (sum == S) {
				return 1;
			} else {
				return 0;
			}
		}
		int total = 0;
		for (int d = 0; d < 2; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				total += dfs(nx, ny, n, m, dx, dy, sum+maps[nx][ny], maps, S);
			}
		}
		return total;

	}

}
