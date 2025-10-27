package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_002 { // 백준 1010 다리놓기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// mCn 순서 유지하며 고르는 경우의 수

		// dp[n][m] = mCn (m개 중 n개 선택)
		int[][] dp = new int[31][31];
		for (int m = 0; m <= 30; m++) {
			dp[0][m] = 1; // mC0 = 1
			dp[m][m] = 1; // mCm = 1
		}
		for (int n = 1; n <= 30; n++) {
			for (int m = n + 1; m <= 30; m++) {
				dp[n][m] = dp[n][m - 1] + dp[n - 1][m - 1]; // 조합 DP
			}
		}

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(dp[N][M]).append('\n');
		}
		System.out.print(sb);

	}

}
