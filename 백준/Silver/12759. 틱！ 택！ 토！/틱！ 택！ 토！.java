import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean player;
	static int[][] board;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		player = br.readLine().equals("1");
		board = new int[3][3];
		answer = 0;

		for(int i = 0; i < 9; i ++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = player ? 1 : 2;
			if(Check()) {
				answer = player ? 1 : 2;
				break;
			}
			player = !player;
		}

		System.out.println(answer);

	}

	private static boolean Check() {

		int temp = player ? 1 : 2;
		//가로 세로
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == temp && board[i][1] == temp && board[i][2] == temp) return true;
			if(board[0][i] == temp && board[1][i] == temp && board[2][i] == temp) return true;
		}
		//대각
		if(board[0][0] == temp && board[1][1] == temp && board[2][2] == temp) return true;
		if(board[0][2] == temp && board[1][1] == temp && board[2][0] == temp) return true;

		return false;
	}

}