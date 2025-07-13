package Stack;

import java.util.Scanner;
import java.util.Stack;

public class st_002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Stack<Integer> stack = new Stack<>();
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			String command = scanner.nextLine();
			if (command.startsWith("push")) {
				int m = Integer.parseInt(command.split(" ")[1]);
				stack.push(m);
			} else if (command.equals("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
					stack.pop();
				}
			} else if (command.equals("size")) {
				System.out.println(stack.size());
			} else if (command.equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (command.equals("top")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			}
		}

	}

}
