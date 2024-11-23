import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,max;
    static int[][] ta, DP;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ta = new int[N][N];
        DP = new int[N][N];
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                ta[i][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }

        DP[0][0] = ta[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    DP[i][j] = DP[i-1][j] + ta[i][j];
                } else if(j == i) {
                    DP[i][j] += DP[i-1][j-1] + ta[i][j];
                } else {
                    DP[i][j] = Math.max(DP[i-1][j-1] + ta[i][j], DP[i-1][j] + ta[i][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, DP[N-1][i]);
        }

        System.out.println(max);


    }

}