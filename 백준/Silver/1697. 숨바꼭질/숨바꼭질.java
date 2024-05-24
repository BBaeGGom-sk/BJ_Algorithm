import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N,K;
	static boolean[] visited;
	static ArrayDeque<Position> deque;
	static class Position {
		int curPos, time;
		Position(int curPos, int time) {
			this.curPos = curPos;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		deque = new ArrayDeque<>();
		visited = new boolean[100001];
		System.out.println(BFS());

	}

	private static int BFS() {

		deque.add(new Position(N,0));
		visited[N] = true;
		int time = 0;

		while (!deque.isEmpty()) {
			Position position = deque.poll();
			if(position.curPos == K) {
				time = position.time;
				break;
			}

			if(position.curPos-1 >= 0 && !visited[position.curPos-1]) {
				deque.add(new Position(position.curPos-1, position.time+1));
				visited[position.curPos-1] = true;
			}

			if(position.curPos+1 <= 100000 && !visited[position.curPos+1]) {
				deque.add(new Position(position.curPos+1, position.time+1));
				visited[position.curPos+1] = true;
			}

			if(position.curPos*2 <= 100000 && !visited[position.curPos*2]) {
				deque.add(new Position(position.curPos*2, position.time+1));
				visited[position.curPos*2] = true;
			}
		}
		return time;
	}

}