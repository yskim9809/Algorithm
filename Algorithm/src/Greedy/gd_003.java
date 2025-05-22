package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class gd_003 {
	/*
	 * 백준 11399
	 * ATM 대기시간 누적합의 최소화
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr);
		int sum = 0;
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			answer += sum + arr[i];
			sum += arr[i];
		}
		System.out.println(answer);

	}

}
/*ATM이 M대라면??
 * 
 * Arrays.sort(people); // 처리시간 짧은 사람부터

        int[] atm = new int[M]; // 각 ATM의 누적 사용시간
        int totalWait = 0;

        for (int i = 0; i < N; i++) {
            int minIndex = 0;

            // 가장 빨리 끝나는 ATM 찾기
            for (int j = 1; j < M; j++) {
                if (atm[j] < atm[minIndex]) {
                    minIndex = j;
                }
            }

            atm[minIndex] += people[i]; // 사람 배정
            totalWait += atm[minIndex]; // 대기시간 누적
        }

        System.out.println(totalWait);*/
