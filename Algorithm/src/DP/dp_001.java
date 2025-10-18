package DP;

import java.util.Arrays;

public class dp_001 {
	/*
	 * 엘리베이터는 1~n층. 어떤 층에서 시작했는지 모름(1..n 어디든 가능). 기록 배열 arr은 엘베가 멈출때마다 이전층과의 거리 기록
	 * 기록을 보고 현재 있을 수 있는 모든 층을 오름차순으로 출력.
	 */

	public static void main(String[] args) {
		int n = 10; // 층 수
		int[] arr = { 9, 2 }; // 이동 거리 기록

		boolean[] cur = new boolean[n + 1]; // 인덱스를 층 번호로 쓰기
		Arrays.fill(cur, true); // 현재 가능한 층 후보 1~n층
		cur[0] = false;

		for (int di : arr) {
			boolean[] next = new boolean[n + 1]; // 다음에 가능한 층 후보

			for (int f = 1; f <= n; f++) {
				if (!cur[f])
					continue; // 불가능한 층 건너뛰기
				int up = f + di;
				int down = f - di;
				if (up <= n) {
					next[up] = true;
				}
				if (down >= 1) {
					next[down] = true;
				}

			}
			cur = next; // 다음 스텝으로 교체;

		}

		// cur에서 true인 값이 가능한 층 후보
		for (int i = 1; i <= n; i++) {
			if (cur[i]) {
				System.out.print(i + " ");
			}
		}

	}

}
