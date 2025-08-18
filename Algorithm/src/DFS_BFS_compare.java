import java.util.*;

public class DFS_BFS_compare {
    // 4방향
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    // -------- BFS 버전: int[]{그림개수, 최대넓이} --------
    static int[] solveBFS(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int count = 0, maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    int area = 0;
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];
                        area++;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir], ny = y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (visited[nx][ny]) continue;
                            if (grid[nx][ny] == 0) continue;
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return new int[]{count, maxArea};
    }

    // -------- DFS 버전: int[]{그림개수, 최대넓이} --------
    static int[] solveDFS(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0, maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    int area = dfs(grid, visited, i, j);
                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return new int[]{count, maxArea};
    }

    static int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int n = grid.length, m = grid[0].length;
        visited[x][y] = true;
        int area = 1;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir], ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visited[nx][ny]) continue;
            if (grid[nx][ny] == 0) continue;
            area += dfs(grid, visited, nx, ny);
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };

        int[][] grid2 = {
            {0, 1, 1},
            {0, 1, 0},
            {1, 0, 0}
        };

        int[] bfs1 = solveBFS(grid1);
        int[] dfs1 = solveDFS(grid1);
        System.out.println("[grid1] BFS -> 그림 개수: " + bfs1[0] + ", 최대 넓이: " + bfs1[1]);
        System.out.println("[grid1] DFS -> 그림 개수: " + dfs1[0] + ", 최대 넓이: " + dfs1[1]);

        int[] bfs2 = solveBFS(grid2);
        int[] dfs2 = solveDFS(grid2);
        System.out.println("[grid2] BFS -> 그림 개수: " + bfs2[0] + ", 최대 넓이: " + bfs2[1]);
        System.out.println("[grid2] DFS -> 그림 개수: " + dfs2[0] + ", 최대 넓이: " + dfs2[1]);
    }
}