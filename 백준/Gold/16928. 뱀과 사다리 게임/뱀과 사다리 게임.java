import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N,M,min;
	static Map<Integer, Integer> move;
	static int[] board;
	static boolean[] visited;
	static ArrayDeque<Position> ad;
	static class Position {
		int curNum;
		int cnt;
		Position(int curNum, int cnt) {
			this.curNum = curNum;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		move = new HashMap<>();
		board = new int[101];
 		visited = new boolean[101];
		ad = new ArrayDeque<>();

		for(int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			move.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		ad.add(new Position(1,0));
		visited[0] = true;
		BFS();
		System.out.println(board[100]);


	}

	private static void BFS() {

		while (!ad.isEmpty()) {
			Position position = ad.poll();
			for(int i = 1; i <= 6; i++) {
				int nNum = position.curNum + i;

				if(nNum <= 100) {
					if(!visited[nNum]) {
						visited[nNum] = true;
						if(move.get(nNum) != null) {
							ad.add(new Position(move.get(nNum), position.cnt+1));
						} else {
							ad.add(new Position(nNum, position.cnt+1));
						}
						board[nNum] = position.cnt+1;
					} else {
						if(board[nNum] > position.cnt+1) {
							board[nNum] = position.cnt+1;
							if(move.get(nNum) != null) {
								ad.add(new Position(move.get(nNum), position.cnt+1));
							} else {
								ad.add(new Position(nNum, position.cnt+1));
							}
						}

					}
				}
			}
		}

	}

}