import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int T,A,B;
	static String answer;
	static String[] command;
	static boolean[] visited;
	static ArrayDeque<Register> ad;
	static class Register {
		int number;
		Register(int number) {
			this.number = number;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			command = new String[10000];
			visited = new boolean[10000];
			ad = new ArrayDeque<>();
			answer = "";
			command[A] = "";
			visited[A] = true;

			ad.add(new Register(A));
			BFS();
			System.out.println(answer);
		}


	}

	private static void BFS() {

		while (!ad.isEmpty()) {
			Register register = ad.poll();
			if(register.number == B) {
				if(answer.isEmpty()) {
					answer = command[register.number];
				} else if(answer.length() > command[register.number].length()) {
					answer = command[register.number];
				}
				continue;
			}

			int curNum = register.number;
			int temp = curNum;
			int[] digit = new int[4];
			for(int i = 0 ; i < 4; i++) {
				digit[i] = temp%10;
				temp /= 10;
			}

			// D
			int D = curNum*2%10000;
			if(visited[D]) {
				if(command[D].length() > command[curNum].length()+1) {
					ad.add(new Register(D));
					command[D] = command[curNum] + "D";
				}
			} else {
				ad.add(new Register(D));
				visited[D] = true;
				command[D] = command[curNum] + "D";
			}

			// S
			int S = curNum == 0 ? 9999 : curNum-1;
			if(visited[S]) {
				if(command[S].length() > command[curNum].length()+1) {
					ad.add(new Register(S));
					command[S] = command[curNum] + "S";
				}
			} else {
				ad.add(new Register(S));
				visited[S] = true;
				command[S] = command[curNum] + "S";
			}

			// L
			int L = ((digit[2] * 10 + digit[1]) * 10 + digit[0]) * 10 + digit[3];
			if(visited[L]) {
				if(command[L].length() > command[curNum].length()+1) {
					ad.add(new Register(L));
					command[S] = command[curNum] + "L";
				}
			} else {
				ad.add(new Register(L));
				visited[L] = true;
				command[L] = command[curNum] + "L";
			}
			// R
			int R = ((digit[0] * 10 + digit[3]) * 10 + digit[2]) * 10 + digit[1];
			if(visited[R]) {
				if(command[R].length() > command[curNum].length()+1) {
					ad.add(new Register(R));
					command[R] = command[curNum] + "R";
				}
			} else {
				ad.add(new Register(R));
				visited[R] = true;
				command[R] = command[curNum] + "R";
			}
		}

	}

}