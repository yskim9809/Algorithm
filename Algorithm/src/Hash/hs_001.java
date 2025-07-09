package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hs_001 {// Lv3.해시 - 베스트앨범

	class Solution {
		public int[] solution(String[] genres, int[] plays) {
			HashMap<String, Integer> map = new HashMap<>();
			// 장르별 노래 재생수 카운트
			for (int i = 0; i < genres.length; i++) {
				String genre = genres[i];
				int play = plays[i];
				map.put(genre, map.getOrDefault(genre, 0) + play);
			}

			HashMap<String, List<int[]>> map2 = new HashMap<>();
			for (int i = 0; i < genres.length; i++) {
				String genre = genres[i];
				int play = plays[i];
				map2.putIfAbsent(genre, new ArrayList<>());
				map2.get(genre).add(new int[] { i, play });
				// 해당 장르의 곡리스트에 곡번호,재생수 추가
			}

			List<String> genreorder = new ArrayList<>(map.keySet());
			genreorder.sort((a, b) -> map.get(b) - map.get(a)); // 장르별 재생수 내림차순

			List<Integer> result = new ArrayList<>();
			for (String genre : genreorder) {
				List<int[]> songList = new ArrayList<>(map2.get(genre));
				songList.sort((a, b) -> {
					if (a[1] != b[1]) {
						return b[1] - a[1];
					} // 곡별 재생수 내림차순
					return a[0] - b[0];
				}); // 곡번호 오름차순

				for (int i = 0; i < songList.size() && i < 2; i++) { // 최대2개만
					result.add(songList.get(i)[0]); // 곡 번호만 저장
				}
			}

			// 배열로 변환
			int[] answer = new int[result.size()];
			for (int i = 0; i < result.size(); i++) {
				answer[i] = result.get(i);
			}
			return answer;
		}
	}
}
