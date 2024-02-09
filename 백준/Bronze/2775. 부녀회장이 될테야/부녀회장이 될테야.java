import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테케 수

		int[][] arr = new int[15][15];

		for(int i = 0; i < arr[0].length; i++) {
			arr[0][i] = i; // 초기 세팅
		}

		for(int a = 1; a < arr[0].length; a++) {
			for(int b = 1; b < arr.length; b++) {
				arr[a][b] = arr[a-1][b] + arr[a][b-1];
			}
		}

		for(int i = 0; i < T; i++) { // 테케 수 만큼 반복
			int k = Integer.parseInt(br.readLine()); // 층
			int n = Integer.parseInt(br.readLine()); // 호

			sb.append(arr[k][n]).append("\n");
		}

		System.out.println(sb);
		br.close();

	}
}