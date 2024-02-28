import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> coin = new ArrayList<>();
		int cnt = 0;

		for(int i = 0; i < N; i++) {
			coin.add(Integer.parseInt(br.readLine()));
		}

		for(int i = coin.size()-1; i >= 0; i--) {
			if(K == 0) {
				break;
			} else if(K/coin.get(i) != 0) {
				cnt += K/coin.get(i);
				K %= coin.get(i);
			}
		}

		System.out.println(cnt);

		br.close();
	}

}