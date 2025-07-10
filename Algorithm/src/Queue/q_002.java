package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class q_002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<int[]> que = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) { // 큐 하나마다 2길이의 배열 담기
			que.add(new int[] { i, Integer.parseInt(st.nextToken()) });
		}
		StringBuilder sb = new StringBuilder();
		while (!que.isEmpty()) {
			int[] pick = que.poll();
			int num = pick[0];
			int move = pick[1];
			sb.append(num).append(" ");
			if (que.isEmpty())
				break;

			int size = que.size();

			if (move > 0) {
				int rot = (move - 1) % size;
				for (int j = 0; j < rot; j++) { // pick 한 풍선을 꺼낼 때 이동값 포함
					que.add(que.poll());
				}
			} else if (move < 0) {
				int rot = (Math.abs(move)) % size;
				for (int j = 0; j < rot; j++) { // 꺼내고나서 이동
					que.addFirst(que.pollLast());
				}
			}

		}
		System.out.println(sb);
	}
}
