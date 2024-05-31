import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T,N,min;
	static String[] MBTI;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			MBTI = new String[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());

			if(N > 32) {
				System.out.println(0);
				continue;
			}

			for(int i = 0; i < N; i++) {
				MBTI[i] = st.nextToken();
			}

			loop:
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					for(int k = j+1; k < N; k++) {
						int cnt = 0;
						for(int l = 0; l < 4; l++) {
							cnt += MBTI[i].charAt(l) != MBTI[j].charAt(l) ? 1 : 0;
							cnt += MBTI[j].charAt(l) != MBTI[k].charAt(l) ? 1 : 0;
							cnt += MBTI[i].charAt(l) != MBTI[k].charAt(l) ? 1 : 0;
						}
						min = Math.min(min,cnt);
						if(min == 0) break loop;
					}
				}
			}

			System.out.println(min);

		}

	}

}