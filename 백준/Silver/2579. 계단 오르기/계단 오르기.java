import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];

		for(int i = 1; i < dp.length; i++) {
			dp[i][0] = Integer.parseInt(br.readLine());
		}

		dp[1][1] = dp[1][0];

		if(N == 1) {
			System.out.println(dp[1][0]);
		} else if(N == 2) {
			System.out.println(dp[1][0] + dp[2][0]);
		} else {
			for(int i = 2; i < dp.length; i++) {
				dp[i][1] = Math.max((dp[i][0] + dp[i-2][1]), dp[i][0] + dp[i-2][2]);
				dp[i][2] = dp[i][0] + dp[i-1][1];
			}
			System.out.println(Math.max(dp[N][1],dp[N][2]));
		}
		br.close();
	}

}