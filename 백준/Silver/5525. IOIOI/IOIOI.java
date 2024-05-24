import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,cnt;
	static String S,P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		P = "IOI";
		cnt = 0;

		for(int i = 1; i < N; i++) {
			P += "OI";
		}

		for(int i = 0; i < S.length()-P.length()+1; i++) {
			if(S.startsWith(P, i)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}


}