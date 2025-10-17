import java.util.HashSet;
import java.util.Set;

public class etc_002 {
	/*
	 * 2차원 좌표가있고 1,2,3,4분면이 있음 그 위에 풍선이 있는데 
	 * 0.0에서 레이저를 발사해서 풍선을 터트릴떄 
	 * 레이저를 최소 몇 번 발사해야 풍선이 모두 터지는지, 
	 * 단 풍선은 좌표 사이가 아닌 좌표점 위에만 있음
	 */

	public static void main(String[] args) {
		int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { -1, -1 }, { 2, 1 }, { 4, 2 }, { -2, -1 } };

		Set<String> dirs = new HashSet<>(); // 벡터방향이 같으면 한번에 터짐
		// 최대공약수로 벡터 계산
		for (int[] p : points) {
			int x = p[0];
			int y = p[1];
			int g = gcd(x, y);
			int nx = x / g;
			int ny = y / g;

			dirs.add(nx + "," + ny);
		}

		System.out.println(dirs.size());

	}
	static int gcd(int a, int b) {
		a=Math.abs(a);
		b=Math.abs(b);
		
		while(b!=0) {
			int t = a%b;
			a=b;
			b=t;
		}
		return a;
	}

}
