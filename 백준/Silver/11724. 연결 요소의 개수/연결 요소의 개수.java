import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] node;
    static int N, M, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        arr = new int[N+1][N+1];
        node = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = 1; //무방향 그래프
            arr[v][u] = 1;
        }

        for(int i = 1; i < N+1; i++) {
            if(!node[i]) {
                DFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();

    }

    private static void DFS(int i) {
        if(node[i]) return;

        node[i] = true;
        for(int a = 1; a < N+1; a++) {
            if(arr[i][a] == 1) {
                DFS(a);
            }
        }
    }
}