import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			int cnt = 1;
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 0)+1);
			}
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				cnt *= (entry.getValue()+1);
			}
			sb.append(cnt-1).append("\n");
		}
		System.out.println(sb);
		br.close();

	}

}