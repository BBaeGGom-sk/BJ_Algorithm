import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		String str;

		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			str = br.readLine();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(String name : list) {
			System.out.println(name);
		}

		br.close();
	}

}