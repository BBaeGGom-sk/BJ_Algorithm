import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] parent;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        DFS(1);

        for(int i = 2; i < N+1; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb.toString());


    }

    private static void DFS(int idx) {
        visited[idx] = true;
        for(int i : graph[idx]) {
            if(!visited[i]) {
                parent[i] = idx;
                DFS(i);
            }
        }
    }

}