import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N,K,L,cnt;
	static int[] dx = {0,1,0,-1};// 우 하 좌 상
	static int[] dy = {1,0,-1,0};
	static boolean[][] appleBoard;
	static boolean[][] snakeBoard;
	static ArrayDeque<Pos> snakeLine;
	static class Pos {
		int x;
		int y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Snake{
		int headX;
		int headY;
		int curDir;
		Snake(int headX, int headY, int curDir) {
			this.headX = headX;
			this.headY = headY;
			this.curDir = curDir;
		}
	}
	static char[] direction;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		direction = new char[10001];
		cnt = 0;

		N = Integer.parseInt(br.readLine());
		appleBoard = new boolean[N][N];
		snakeBoard = new boolean[N][N];

		snakeLine = new ArrayDeque<>();
		snakeLine.addFirst(new Pos(0,0));
		Snake snake = new Snake(0,0,0);
		snakeBoard[0][0] = true;

		// 사과
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			appleBoard[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
		}

		// 방향 변환
		L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			direction[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}

		while (true) {
			// 방향만 전환
			if(direction[cnt] == 'D') {
				snake.curDir = (snake.curDir + 1) % 4;
			} else if(direction[cnt] == 'L') {
				snake.curDir = (snake.curDir + 3) % 4;
			}

			// 시간 증가
			cnt++;

			// 이동할 곳 체크 과정
			int nx = snake.headX + dx[snake.curDir];
			int ny = snake.headY + dy[snake.curDir];
				// 몸박 or 벽 만나면 끝
			if(0 > nx || nx >= N || 0 > ny || ny >= N || snakeBoard[nx][ny]) {
				break;
			}

			// 이동
			snakeLine.addFirst(new Pos(nx,ny));
			snakeBoard[nx][ny] = true;
			snake.headX = nx;
			snake.headY = ny;
				// 사과 없는 경우
			if(!appleBoard[nx][ny]) {
				Pos pos = snakeLine.pollLast();
				snakeBoard[pos.x][pos.y] = false;
			} else { // 있는 경우 (치워야함 ..!)
				appleBoard[nx][ny] = false;
			}

		}

		System.out.println(cnt);

	}

}