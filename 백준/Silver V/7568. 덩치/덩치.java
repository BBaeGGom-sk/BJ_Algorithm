import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Integer> wList = new ArrayList<>();
		List<Integer> hList = new ArrayList<>();
		List<Integer> rank =  new ArrayList<>();

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wList.add(Integer.parseInt(st.nextToken()));
			hList.add(Integer.parseInt(st.nextToken()));
		}

		for(int i = 0; i < wList.size(); i++) {
			int cnt = 1;
			for(int j = 0; j < hList.size(); j++) {
				if(i == j) continue;
				if(wList.get(i) < wList.get(j)) {
					if(hList.get(i) < hList.get(j)) {
						cnt++;
					}
				}
			}
			rank.add(cnt);
		};

		for(int item : rank) {
			sb.append(item).append(" ");
		}
		System.out.println(sb);

		br.close();

	}
}