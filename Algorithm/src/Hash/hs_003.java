package Hash;

import java.util.HashMap;

public class hs_003 { // Lv1.해시 - 완주하지 못한 선수
	class Solution {
		public String solution(String[] participant, String[] completion) {
			String answer = "";
			HashMap<String, Integer> map = new HashMap<>();
			for (String name : completion) {
				map.put(name, map.getOrDefault(name, 0) + 1);
			}
			for (String name : participant) {
				if (!map.containsKey(name)) {
					answer = name;
				} else if (map.get(name) == 0) {
					answer = name;
				} else {
					map.put(name, map.get(name) - 1);
				}
			}
			return answer;
		}
	}

}
