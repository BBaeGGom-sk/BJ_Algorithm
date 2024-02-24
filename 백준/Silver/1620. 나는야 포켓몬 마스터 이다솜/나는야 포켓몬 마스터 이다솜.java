import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String str;

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> name = new HashMap<>();
		Map<Integer, String> number = new HashMap<>();

		for(int i = 0; i < N; i++) {
			str = br.readLine();
			name.put(str, i+1);
			number.put(i+1, str);
		}

		for(int i = 0; i < M; i++) {
			str = br.readLine();
			if(str.matches("[0-9]+")) {
				sb.append(number.get(Integer.parseInt(str))).append("\n");
			} else {
				sb.append(name.get(str)).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}


}