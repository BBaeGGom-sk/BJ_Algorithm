import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, n;
    static int[][] sticker, DP;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n];
            DP = new int[2][n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                sticker[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                sticker[1][i] = Integer.parseInt(st.nextToken());
            }

            DP[0][0] = sticker[0][0];
            DP[1][0] = sticker[1][0];

            for (int i = 1; i < n; i++) {
                DP[0][i] = Math.max(DP[1][i - 1], (i > 1 ? DP[1][i - 2] : 0)) + sticker[0][i];
                DP[1][i] = Math.max(DP[0][i - 1], (i > 1 ? DP[0][i - 2] : 0)) + sticker[1][i];
            }

            sb.append(Math.max(DP[0][n - 1], DP[1][n - 1])).append("\n");
        }

        System.out.print(sb.toString());
    }
}