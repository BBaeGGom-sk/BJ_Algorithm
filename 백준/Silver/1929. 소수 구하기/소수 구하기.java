import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[N+1];

		prime[0] = prime[1] = true;

		for(int i = 2; i*i <= N; i++) {
			if(!prime[i]) {
				for(int j = i*i; j <= N; j += i) {
					prime[j] = true;
				}
			}
		}

		for(int i = M; i <= N; i++) {
			if(prime[i] == false) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb);

		br.close();
	}
}