import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] dots;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dots = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dots[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(dots);

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(binarySearch(s,e)).append("\n");
		}

		System.out.println(sb);



	}

	private static int binarySearch(int s, int e) {
		int start = 0;
		int end = dots.length-1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if(dots[mid] > e) end = mid - 1;
			else start = mid + 1;
		}

		int endIdx = end + 1;

		start = 0;
		end = dots.length-1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if(dots[mid] < s) start = mid + 1;
			else end = mid - 1;
		}

		int startIdx = start;

		return endIdx - startIdx;
	}

}