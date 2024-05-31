import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,normal,abnormal;
	static int[][] grid;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		visited = new boolean[N][N];
		normal = 0;
		abnormal = 0;

		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < N; j++) { // R - 0 , G - 1 , B - 2
				if(temp.charAt(j) == 'R') {
					grid[i][j] = 0;
				} else if(temp.charAt(j) == 'G') {
					grid[i][j] = 1;
				} else {
					grid[i][j] = 2;
				}
			}
		}

		Count(true);
		Count(false);

		System.out.println(normal + " " + abnormal);

	}


	private static void Count(boolean isNormal) {
		visited = new boolean[N][N];
		int cnt = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					cnt++;
					DFS(isNormal,i,j,grid[i][j]);
				}
			}
		}

		if(isNormal) normal = cnt;
		else abnormal = cnt;

	}

	private static void DFS(boolean isNormal,int x, int y,int target) {
		visited[x][y] = true;
		if(isNormal && target == 0) grid[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && grid[nx][ny] == target) {
				visited[nx][ny] = true;
				DFS(isNormal,nx,ny,target);

			}
		}
	}

}