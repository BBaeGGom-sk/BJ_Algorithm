import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T,M,N,x,y,LCM;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		loop :
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			LCM = 0;

			if(M-N >= 0) LCM = getLCM(M,N);
			else LCM = getLCM(N,M);

			for(int i = x; i < LCM; i += M) {
				if(i%N == y) {
					sb.append(i+1).append("\n");
					continue loop;
				}
			}

			sb.append(-1).append("\n");

		}
		System.out.println(sb);

	}

	private static int getLCM(int x, int y) {
		return x*y / getGCD(x,y);
	}

	private static int getGCD(int x, int y) {
		if(y == 0) {
			return x;
		}
		return getGCD(y, x%y);
	}

}