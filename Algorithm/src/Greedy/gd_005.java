package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class gd_005 {//하나의 테이프를 최소한으로 잘라 구멍을 모두 메우기

	public static void main(String[] args) {
		int[] holes = { 1, 3, 8, 10, 11 };
		int k = 8; // 테이프 총 길이

		Arrays.sort(holes);
		int n = holes.length;

		// 처음에는 구멍 개수만큼 조각, 잘라야 하는 횟수 = n-1
		int cuts = n - 1;
		int remain = k - n; // 구멍 위치를 덮는 데 쓴 길이 제외, 남은 길이

		// 구멍 사이 간격 계산
		List<Integer> gaps = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			int gap = holes[i] - holes[i - 1] - 1;
			gaps.add(gap); // 연속이면 gap=0, 떨어져 있으면 그만큼 양수
		}

		Collections.sort(gaps); // 작은 간격부터 처리 (그리디)

		for (int gap : gaps) {
			if (gap == 0) {
				// 연속된 구멍 → 추가 테이프 소모 없음
				cuts--;
			} else if (gap <= remain) {
				// 떨어져 있지만 남은 테이프 길이로 메꿀 수 있는 경우
				remain -= gap;
				cuts--;
			} else {
				// 남은 테이프로는 못 메움 → 더 이상 합칠 수 없음
				break;
			}
		}

		System.out.println("필요한 조각 수: " + (cuts + 1));
		System.out.println("최소 자른 횟수: " + cuts);

	}

}
