package DFS;

public class df_003 {
	static class Solution {// Lv.2 dfs - 타겟 넘버
		static int count = 0;
		static int[] numbers2;
		static int target2;

		public int solution(int[] numbers, int target) {
			int answer = 0;
			numbers2 = numbers;
			target2 = target;
			dfs(0, 0);
			return count;
		}

		static void dfs(int idx, int sum) {
			if (idx == numbers2.length) {
				if (sum == target2) {
					count++;
				}
				return;
			}
			dfs(idx + 1, sum + numbers2[idx]);
			dfs(idx + 1, sum - numbers2[idx]);

		}
	}
}
