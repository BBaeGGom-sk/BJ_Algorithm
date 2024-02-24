import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		while (true) {
			if(N < 0) {
				System.out.println(-1);
				break;
			}

			if(N == 4 || N == 7) {
				System.out.println(-1);
				break;
			}
			if(N % 5 == 0) {
				cnt += N/5;
				System.out.println(cnt);
				break;
			} else {
				N -= 3;
				cnt++;
			}
		}
		br.close();
	}
}