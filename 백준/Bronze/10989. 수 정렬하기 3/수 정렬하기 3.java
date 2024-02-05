import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 카운팅정렬
		int[] cnt = new int[10001]; // 숫자 크기 범위 0~10000
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}

		for(int i = 1; i < cnt.length; i++) {
			for(int j = 0; j < cnt[i]; j++) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb);

	}
}