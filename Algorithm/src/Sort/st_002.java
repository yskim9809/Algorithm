package Sort;

import java.util.Arrays;

public class st_002 {
	/*
	 * 선택정렬: 가장 큰 원소의 인덱스를 저장한뒤 arr[i]와 위치를 바꾼다
	 */
	public static void main(String[] args) {
		int[] arr = { 9, 1, 6, 5, 2 };

		for (int i = arr.length - 1; i > 0; i--) {
			int maxIdx = 0;
			for (int j = 0; j <= i; j++) {
				if (arr[j] > arr[maxIdx]) {
					maxIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = temp;
			System.out.println("** " + Arrays.toString(arr));

		}
		System.out.println(Arrays.toString(arr));

	}

}
