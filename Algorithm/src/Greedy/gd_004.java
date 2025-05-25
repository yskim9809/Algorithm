package Greedy;

import java.util.Scanner;

public class gd_004 {
	/*
	 * 백준 13305 
	 * 주유값의 최소화
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] road = new int[n - 1]; // 각 경유지 사이의 거리
		int[] price = new int[n]; // 경유지점 기름값

		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			road[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			price[i] = scanner.nextInt();
		}
		int min = price[0];
		for (int i = 0; i < n - 1; i++) {
			if (price[i] < min) {
				min = price[i];
			}
			sum += (long) min * road[i];
		}
		System.out.println(sum);

	}

}
