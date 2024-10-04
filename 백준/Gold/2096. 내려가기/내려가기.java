import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board, maxDp, minDp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N+1][3];
        maxDp = new int[N+1][3];
        minDp = new int[N+1][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                board[i+1][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxDp[0][0] = maxDp[0][1] = maxDp[0][2] = 0;
        minDp[0][0] = minDp[0][1] = minDp[0][2] = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) {
                    maxDp[i][0] = Math.max(maxDp[i-1][0] + board[i][0], maxDp[i-1][1] + board[i][0]);
                    minDp[i][0] = Math.min(minDp[i-1][0] + board[i][0], minDp[i-1][1] + board[i][0]);
                } else if(j == 1) {
                    maxDp[i][1] = Math.max(maxDp[i-1][0] + board[i][1], Math.max(maxDp[i-1][1] + board[i][1],
                            maxDp[i-1][2] + board[i][1]));
                    minDp[i][1] = Math.min(minDp[i-1][0] + board[i][1], Math.min(minDp[i-1][1] + board[i][1],
                            minDp[i-1][2] + board[i][1]));
                } else {
                    maxDp[i][2] = Math.max(maxDp[i-1][1] + board[i][2], maxDp[i-1][2] + board[i][2]);
                    minDp[i][2] = Math.min(minDp[i-1][1] + board[i][2], minDp[i-1][2] + board[i][2]);
                }
            }
        }

        System.out.println(Math.max(maxDp[N][0], Math.max(maxDp[N][1], maxDp[N][2])) + " " +
                Math.min(minDp[N][0], Math.min(minDp[N][1], minDp[N][2])));

    }
}