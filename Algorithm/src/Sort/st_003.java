package Sort;

import java.util.Arrays;

public class st_003 {
	/*
	 * 병합정렬 : 1.주어진 리스트를 2개로 나눈다. 
	 * 			2.나눈 리스트 2개를 정렬한다. 
	 * 			3.정렬된 두 리스트를 합친다. 를 반복한다
	 */
	public static void main(String[] args) {
		int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
		mergeSort(arr);
		System.out.println("정렬 결과: " + Arrays.toString(arr));

	}

	public static void mergeSort(int[] arr) {
		if (arr.length <= 1)
			return;

		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid); // 복사할 배열, 복사 시작 인덱스, 복사 끝 인덱스(-1)
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);

		mergeSort(left);
		mergeSort(right);

		merge(arr, left, right);
	}

	private static void merge(int[] arr, int[] left, int[] right) {
		int i = 0; // 왼쪽 배열 인덱스
		int j = 0; // 오른쪽 배열 인덱스
		int k = 0; // arr 배열 인덱스

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i = i + 1;
				k = k + 1;
			} else {
				arr[k] = right[j];
				j = j + 1;
				k = k + 1;
			}
		}

		// 왼쪽 배열에 남은 요소들 복사
		while (i < left.length) {
			arr[k] = left[i];
			i = i + 1;
			k = k + 1;
		}

		// 오른쪽 배열에 남은 요소들 복사
		while (j < right.length) {
			arr[k] = right[j];
			j = j + 1;
			k = k + 1;
		}
	}

}
