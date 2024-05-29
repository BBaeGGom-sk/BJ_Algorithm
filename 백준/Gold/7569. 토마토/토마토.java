import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int M,N,H,day;
	static int[][][] box;
	static boolean isComplete, isZero;
	static class Cord {
		int x;
		int y;
		int z;

		Cord(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static ArrayDeque<Cord> ad;
	static boolean[][][] visited;
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이
		day = 0; // 소요기간
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		ad = new ArrayDeque<>();
		isComplete = true;
		// isZero = false;

		if(M == 0 && N == 0 && H == 0) {
			System.out.println(-1);
			System.exit(0);
		}


		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					box[k][i][j] = temp;
					if (temp == 1) {
						ad.add(new Cord(j,i,k));
						visited[k][i][j] = true;
					} else if(temp == 0) {
						// isZero = true;
						isComplete = false;
					}
				}
			}
		}

		if (isComplete) { // 이미 다 익음
			day = 0;
		} else {
			Check();
		}


		System.out.println(day);

	}

	private static void Check() {
		int cnt = 0;
		while (!ad.isEmpty()) {
			int size = ad.size();
			for(int i = 0; i < size; i++) {
				Cord cord = ad.poll();

				for(int j = 0; j < 6; j++) {
					int nx = cord.x + dx[j];
					int ny = cord.y + dy[j];
					int nz = cord.z + dz[j];
					if(nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && box[nz][ny][nx] == 0 && !visited[nz][ny][nx]) {
						ad.add(new Cord(nx, ny, nz));
						visited[nz][ny][nx] = true;
						box[nz][ny][nx] = 1;
					}
				}
			}

			cnt++;
		}

		day = cnt-1;

		loop :
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[k][i][j] == 0) {
						day = -1;
						break loop;
					}
				}
			}
		}

	}

}