package BFS;

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
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		
		 

	}

}
