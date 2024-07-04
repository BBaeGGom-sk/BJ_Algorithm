import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int L = -1;
	static int R = -1;
	static int C = -1;
	static int minute,x,y,z;
	static char[][][] building;
	static boolean[][][] visited;
	static ArrayDeque<Pos> q;
	static int[] dx = {1,-1,0,0,0,0};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static class Pos{
		int curX;
		int curY;
		int curZ;
		int cnt;

		Pos(int x, int y, int z, int cnt) {
			this.curX = x;
			this.curY = y;
			this.curZ = z;
			this.cnt = cnt;
		}

	}



	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {

			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if(L == 0 && R == 0 && C == 0) break;

			x = 0; y = 0; z = 0;
			minute = -1;
			building = new char[L][R][C];
			visited = new boolean[L][R][C];
			q = new ArrayDeque<>();

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						char temp = str.charAt(k);
						building[i][j][k] = str.charAt(k);
						if (temp == 'S') {
							q.add(new Pos(j, k, i, 0));
							visited[i][j][k] = true;
						}
						else if(temp == 'E') {
							x = j;
							y = k;
							z = i;
							building[i][j][k] = '.';
						}
					}
				}
				br.readLine();
			}

			minute = BFS();
			if(minute != -1) sb.append("Escaped in ").append(minute).append(" minute(s).").append("\n");
			else sb.append("Trapped!").append("\n");

		}

		System.out.println(sb);

	}

	private static int BFS() {
		int cnt = -1;

		while (!q.isEmpty()) {
			Pos pos = q.poll();

			if(pos.curX == x && pos.curY == y && pos.curZ == z) {
				cnt = pos.cnt;
				break;
			}

			for(int i = 0; i < 6; i++) {
				
				int nx = pos.curX + dx[i];
				int ny = pos.curY + dy[i];
				int nz = pos.curZ + dz[i];

				if(Check(nx,ny,nz)) {
					q.add(new Pos(nx,ny,nz,pos.cnt+1));
					visited[nz][nx][ny] = true;
				}
			}

		}

		return cnt;
	}

	private static boolean Check(int nx, int ny, int nz) {

		return 0 <= nx && R > nx && 0 <= ny && C > ny && 0 <= nz && L > nz
			&& !visited[nz][nx][ny] && building[nz][nx][ny] == '.';

	}

}