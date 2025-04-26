package Sort;

import java.util.Arrays;

public class st_004 {
	/*
	 * 퀵 정렬: pivot보다 작은 건 왼쪽, 큰 건 오른쪽을 만들어가면서 정렬한다.
	 * 		  이 과정을 외쪽 오른쪽에서 계속 반복한다. (pivot 제자리 찾아주기)
	 * 		  
	 */

	public static void main(String[] args) {
		int[] arr = { 29, 10, 14, 37, 13 };

		// 배열 전체를 quickSort로 정렬
		quickSort(arr, 0, arr.length - 1);

		System.out.println("정렬 결과: " + Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int low, int high) {
		// 정렬할 구간이 남아 있을 때만 실행 (low == high면 정렬할 필요 없음)
		if (low < high) {
			// pivot을 arr[high] (맨 끝 값)으로 정함
			int pivot = arr[high];

			// i는 pivot보다 작은 수들이 모이는 구간의 마지막 인덱스
			int i = low - 1; // 아직 작은 수가 하나도 없기 때문에 -1부터 시작

			// j는 low부터 high-1까지 pivot과 비교하면서 돈다
			for (int j = low; j < high; j++) {
				if (arr[j] <= pivot) { // pivot보다 작거나 같은 값이면
					i++; // 작은 수 모으는 구역을 한 칸 확장하고
					// arr[i]와 arr[j]를 교환
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				// (arr[j]가 pivot보다 크면 아무것도 안 하고 넘어감)
			}

			// for문이 끝났으면:
			// i+1 자리는 pivot이 들어가야 하는 자리
			// 그래서 arr[i+1]과 pivot(arr[high])을 바꿔줌
			int temp = arr[i + 1];
			arr[i + 1] = arr[high];
			arr[high] = temp;

			// 이제 pivot은 i+1 자리에 확정!

			int pivotIndex = i + 1; // pivot이 최종적으로 들어간 자리

			// pivot을 기준으로 왼쪽 구간을 다시 정렬
			quickSort(arr, low, pivotIndex - 1);

			// pivot을 기준으로 오른쪽 구간을 다시 정렬
			quickSort(arr, pivotIndex + 1, high);
		}
	}

}
