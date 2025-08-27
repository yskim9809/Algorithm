package Stack;

import java.util.Scanner;
import java.util.Stack;

public class st_005 { // 백준 9012 괄호

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt(); // 테스트 케이스 개수
		sc.nextLine(); // 개행 제거

		for (int tc = 0; tc < T; tc++) {
			String str = sc.nextLine(); // 괄호 문자열
			Stack<String> st = new Stack<>();
			boolean check = true;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					st.add("(");
				} else {
					if (!st.isEmpty()) {
						st.pop();
					} else {
						check = false;
						break;
					}

				}
			}
			sb.append(check && st.isEmpty() ? "YES" : "NO").append('\n');

		}
		System.out.println(sb);

	}

}
