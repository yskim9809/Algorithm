package BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bf_001 {
	/*
	 * 약에 포함되는 성분 1~n개가 있고 n은 약의 개수 bans[]는 조합했을때 부작용이 일어나는 약들의 조합
	 * bans["235","245","13"]. 전체 약의 조합에서 부작용 조합을 빼면 몇 개인지
	 */

	public static void main(String[] args) {
		// 부분집합의 개수 = 2^n-1(공집합)
		int n = 4;
		String[] bans = { "12", "34" };

		List<String> bans2 = Arrays.asList("12", "34");
		// 전체 조합 생성
		List<String> all = new ArrayList<>();
		for (int i = 1; i < (1 << n); i++) {
			StringBuilder sb = new StringBuilder();
			for (int bit = 0; bit < n; bit++) {
				if ((i & (1 << bit)) != 0)
					sb.append(bit + 1);
			}
			all.add(sb.toString());
		}

		// 부작용 포함된 조합 제거
		List<String> safe = new ArrayList<>();
		for (String comb : all) {
			boolean bad = false;
			for (String ban : bans) {
				if (containsAll(comb, ban)) {
					bad = true;
					break;
				}
			}
			if (!bad)
				safe.add(comb);
		}

		System.out.println("안전한 조합 개수: " + safe.size());
		System.out.println(safe);

	}

	static boolean containsAll(String combo, String ban) {
		for (char ch : ban.toCharArray()) {
			if (combo.indexOf(ch) == -1)
				return false;
		}
		return true;
	}

}
