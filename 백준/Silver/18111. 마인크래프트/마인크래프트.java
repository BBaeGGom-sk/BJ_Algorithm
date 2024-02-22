import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 가로
		int M = Integer.parseInt(st.nextToken()); // 세로
		int B = Integer.parseInt(st.nextToken()); // 최초 인벤토리 블럭 수
		int[][] arr = new int[N][M]; // 집터
		int min = 256; // 최소높이용
		int max = 0; // 최대높이용
		int minTime = Integer.MAX_VALUE;
		int height = 0;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				max = Math.max(max,num);
				min = Math.min(min,num);
			}
		}

		for(int level = min; level < max+1; level++) {
			int block = 0;
			int time = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] > level) {
						int temp = arr[i][j] - level;
						time += temp * 2;
						block += temp;
					} else if(arr[i][j] < level) {
						int temp = level - arr[i][j];
						time += temp;
						block -= temp;
					}
				}
			}
			if(B + block >= 0) { // 가능
				if(minTime >= time) {
					minTime = time;
					height = level;
				}
			}
		}

		System.out.println(minTime + " " + height);

		br.close();
	}
}