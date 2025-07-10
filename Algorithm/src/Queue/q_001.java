package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q_001 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		Deque<Integer> que = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String str = scanner.nextLine();
			if (str.startsWith("push")) {
				StringTokenizer st = new StringTokenizer(str);
			    st.nextToken(); // "push" 버림
			    int num = Integer.parseInt(st.nextToken());
			    que.add(num);
			} else if (str.equals("pop")) {
				sb.append(que.isEmpty() ? -1 : que.poll()).append("\n");
			} else if (str.equals("size")) {
				sb.append(que.size()).append("\n");
			} else if (str.equals("empty")) {
				sb.append(que.isEmpty() ? 1 : 0).append("\n");
			} else if (str.equals("front")) {
				sb.append(que.isEmpty() ? -1 : que.peek()).append("\n");
			} else if (str.equals("back")) {
				sb.append(que.isEmpty() ? -1 : que.peekLast()).append("\n");
			}
		}
		System.out.print(sb.toString());

	}

}
