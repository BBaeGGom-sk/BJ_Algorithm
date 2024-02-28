import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Map<String, String> site = new HashMap<>();

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			site.put(st.nextToken(), st.nextToken());
		}

		for(int i = 0; i < M; i++) {
			sb.append(site.get(br.readLine())).append("\n");
		}

		System.out.println(sb);

		br.close();
	}

}