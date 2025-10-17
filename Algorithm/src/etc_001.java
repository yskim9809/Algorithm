import java.util.ArrayList;
import java.util.List;

public class etc_001 {
	/*영화관 좌석 배치도가 ["M--NN-","-M-C--","-N---N"] 
 	C는 확진자, M은 마스크 낀사람, N은 노마스크, -은 빈자리일때 
 	맨해튼거리 2이내에 있는 M과 3이내에 있는 N이 밀접촉자로 분류, 
 	맨해튼거리는 좌석 좌표가 (r1,c1)(r2,c2) 일때 |r1-r2|+|c1-c2| 
 	여기서 밀접촉자의 수를 리턴한다면*/

	public static void main(String[] args) {
		String[] layout = {
	            "M--NN-",
	            "-M-C--",
	            "-N---N"
	        };

			int R = layout.length; // 행
			int C = layout[0].length(); // 열

			// 확진자 좌표 모으기
			List<int[]> infected = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (layout[i].charAt(j) == 'C') {
						infected.add(new int[] { i, j });
					}
				}
			}
			int count = 0;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (layout[i].charAt(j) == 'M') {
						for (int[] ci : infected) {
							if (manhattan(ci[0], ci[1], i, j) <= 2) {
								count++;
								break; //중복 카운트 방지
							}
						}
					} else if (layout[i].charAt(j) == 'N') {
						for (int[] ci : infected) {
							if (manhattan(ci[0], ci[1], i, j) <= 3) {
								count++;
								break;
							}
						}
					}
				}
			}
			
			System.out.println(count);

	}

	private static int manhattan(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

}
