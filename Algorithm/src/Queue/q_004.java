package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class q_004 { // 백준 2164 제일 마지막에 남는 카드

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Deque<Integer> que = new ArrayDeque<>();
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			que.add(i);
		}
		while (que.size() > 1) {
			que.poll();
			que.add(que.poll());
		}
		System.out.println(que.peek());

	}

}
