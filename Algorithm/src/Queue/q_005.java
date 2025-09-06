package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q_005 { // 백준 11866 요세푸스 문제 0

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append('<');

		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int K = Integer.parseInt(st.nextToken()); // 제거할 순서

		Deque<Integer> que = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			que.add(i);
		}
		int count = 0;
		while (que.size() > 1) {
			count++;
			
			if(count>=K&&count%K==0) {
				sb.append(que.poll()).append(", ");
			}else {
				que.add(que.poll());
			}
		}
		sb.append(que.poll()).append('>');
		System.out.println(sb);

	}

}
