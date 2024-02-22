import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(N/5 != 0) {
			cnt += N/5;
			N /= 5;
		}
		System.out.println(cnt);

		br.close();

	}
}