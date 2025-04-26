package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class gd_002 {
	/*
	 * 백준 11047 
	 * 필요한 동전 개수의 최솟값
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); //동전 종류 수
		int k = scanner.nextInt(); //금액
		int[] arr = new int[n];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			if (k / arr[i] > 0) {
				cnt += k / arr[i];
				k = k % arr[i];
			}
		}
		System.out.println(cnt);

	}

}
