package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class st_006 {
	/*택배 상자가 arrive[] 순서대로 도착, 도착 순서대로 구역에 쌓기
	 * 기존의 구역위에 쌓거나 새로운 구역 만들수있음. 
	 * 모든 상자를 쌓고 출고 순서대로 꺼내기, 맨 위 상자만 꺼내기 가능 
	 * 출고 순서 out[]가 주어질 때 해당 순서대로 꺼낼 수 있는 적재구역의 최소 개수*/

	public static void main(String[] args) {
		int[] arrive = {3, 1, 4, 2};     // 도착 순서
        int[] out    = {1, 2, 3, 4};     // 출고 순서
        System.out.println(minZones(arrive, out)); // 2

	}
	 public static int minZones(int[] arrive, int[] out) {
	        int n = arrive.length;
	        Map<Integer, Integer> pos = new HashMap<>(n*2);
	        for (int i = 0; i < n; i++) pos.put(out[i], i); // 출고 인덱스

	        int[] seq = new int[n];
	        for (int i = 0; i < n; i++) seq[i] = pos.get(arrive[i]);

	        // LIS 길이 (엄격 증가)
	        ArrayList<Integer> tails = new ArrayList<>();
	        for (int v : seq) {
	            int idx = Collections.binarySearch(tails, v);
	            if (idx < 0) idx = -idx - 1;       // lower_bound
	            if (idx == tails.size()) tails.add(v);
	            else tails.set(idx, v);
	        }
	        return tails.size();
	    }

}
