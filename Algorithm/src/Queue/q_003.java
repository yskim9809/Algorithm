package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class q_003 {

	public static void main(String[] args) throws IOException {
		Deque<Integer> que = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] type = new int[n];
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			type[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = n - 1; i >= 0; i--) {
			if (type[i] == 0) {
				que.add(num[i]);
			}
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			que.add(Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(que.poll()).append(" ");
		}
		System.out.println(sb);
	}

}
