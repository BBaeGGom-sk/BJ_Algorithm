import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int cnt;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			cnt = 0;
			int temp = Integer.parseInt(br.readLine());
			for(int j = 1; j < 4; j++) {
				perm(temp, j);
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void perm(int i, int j) {
		if(i-j == 0) {
			cnt++;
			return;
		}

		for(int a = 1; a < 4; a++) {
			if(i-j < 0) {
				continue;
			}
			perm(i-j,a);
		}
	}

}