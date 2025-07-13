package Stack;

import java.util.Scanner;
import java.util.Stack;

public class st_003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			Stack<String> stack = new Stack<>();
			String str = scanner.nextLine();
			Boolean check = true;
			if (str.equals(".")) {
				break;
			}
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push("(");
				} else if (str.charAt(i) == '[') {
					stack.push("[");
				} else if (str.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek().equals("(")) {
						stack.pop();
					} else {
						check = false;
						break;
					}
				} else if (str.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek().equals("[")) {
						stack.pop();
					} else {
						check = false;
						break;
					}
				}
			}
			System.out.println(check == true && stack.isEmpty() ? "yes" : "no");
		}

	}

}
