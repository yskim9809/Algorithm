package Stack;

import java.util.Scanner;
import java.util.Stack;

public class st_004 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			String[] srt = scanner.nextLine().split("");
			Stack<Integer> stack = new Stack<>();
			Boolean flag = true;
			for (String s : srt) {
				if (s.equals("(")) {
					stack.push(0);
				} else if (s.equals(")")) {
					if (stack.isEmpty()) {
						flag = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (stack.size() > 0 || flag == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}

	}

}
