package Sort;

import java.util.Arrays;

public class st_001 {
	/*
	 * 버블정렬: 앞에서부터 인접한 두 원소를 비교해 큰 값이 뒤로 갈 수 있게한다.
	 */
	public static void main(String[] args) {
		int[] arr = { 9, 1, 6, 8, 2 };
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				//System.out.println("*  " + Arrays.toString(arr));
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}
