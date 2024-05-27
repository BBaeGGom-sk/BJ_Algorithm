import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,V,W,KB,min;
	static int[][] graph;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		min = Integer.MAX_VALUE;
		KB = 0;

		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				if(i != j) graph[i][j] = 9999999;
			}
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			graph[V][W] = graph[W][V] = 1;
		}

		floyd();

		for(int i = 1; i < N+1; i++) {
			int temp = 0;
			for(int j = 1; j < N+1; j++) {
				if(graph[i][j] != 0) {
					temp += graph[i][j];
				}
			}
			if(min > temp) {
				min = temp;
				KB = i;
			}
		}

		System.out.println(KB);

	}

	private static void floyd() { // 경출도

		for(int k = 1; k < N+1; k++) {
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++) {
					graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
				}
			}
		}

	}

}