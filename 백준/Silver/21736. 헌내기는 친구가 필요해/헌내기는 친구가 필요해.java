import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,cnt,curX,curY;
    static boolean[][] visited;
    static int[][] campus;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // x
        M = Integer.parseInt(st.nextToken()); // y
        campus = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < M; j++) {
                if(temp.charAt(j) == 'X') {
                    campus[i][j] = 1;
                } else if(temp.charAt(j) == 'P') {
                    campus[i][j] = 2;
                } else if(temp.charAt(j) == 'I') {
                    curX = i; curY = j;
                }
            }
        }

        DFS(curX, curY);
        if(cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
        br.close();

    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        if(campus[x][y] == 2) {
            cnt++;
        }

        if(campus[x][y] == 1) {
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N & ny < M && !visited[nx][ny]) {
                DFS(nx,ny);
            }
        }

    }
}