import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[41][2];

		dp[0][0] = 1; dp[0][1] = 0;
		dp[1][0] = 0; dp[1][1] = 1;

		for(int i = 2; i < dp.length; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}

		for(int i = 0; i < T; i++) {
			int temp = Integer.parseInt(br.readLine());
			sb.append(dp[temp][0]).append(" ").append(dp[temp][1]).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}