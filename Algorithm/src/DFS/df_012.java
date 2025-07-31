package DFS;

public class df_012 {

	public static void main(String[] args) { //서로 연결된 네트워크 그룹의 총 개수(그래프)
		int N = 3; //직원 수 == 노드 수
		int[][] computers = { //서로 연결되면 1
		    {1,1,0},
		    {1,1,0},
		    {0,0,1}
		};
		
		//boolean[][] visited = new boolean[n][m]; //칸별 방문체크
		boolean[] visited = new boolean[N]; //노드별 방문체크
		int count = 0;

		//int[] dx = { 0, 0, 1, -1 };
		//int[] dy = { 1, -1, 0, 0 }; 그래프에서 불필요

		for (int i = 0; i < N; i++) {
			if(!visited[i]) { //시작점이기 때문에 computers[i][j]==1 체크 안함. dfs내부에서만 체크함
				dfs(i, computers, visited, N);
				count++;
			}
		}
		
		System.out.println(count);

	}

	private static void dfs(int i, int[][] computers, boolean[] visited, int N) {
		//도착점(return) 없이 한 그룹을 모두 방문하면 count++;
		visited[i] = true;
		for(int j=0; j<N; j++) {
			if(computers[i][j]==1&&!visited[j]) {
				dfs(j,computers,visited, N);
			}
		}
		
	}

	

}
