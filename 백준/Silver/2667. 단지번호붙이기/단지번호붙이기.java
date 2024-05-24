import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N,max;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					max = 1;
					visited[i][j] = true;
					Count(i, j);
					list.add(max);
				}
			}
		}

		Collections.sort(list);

		sb.append(list.size()).append("\n");
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb);

	}

	private static void Count(int x, int y) {

		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] == 1) {
				visited[nx][ny] = true;
				max++;
				Count(nx,ny);
			}
		}
	}
}