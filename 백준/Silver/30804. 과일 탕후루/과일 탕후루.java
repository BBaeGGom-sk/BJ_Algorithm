import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, left, right, max, cnt;
	static int[] tang, type;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		left = 0;
		right = 0;
		max = Integer.MIN_VALUE;
		cnt = 0;
		tang = new int[N];
		type = new int[10];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tang[i] = Integer.parseInt(st.nextToken());
		}

		twoPointer();
		System.out.println(max);

	}

	private static int twoPointer() {
		if(right >= N) return max;

		type[tang[right]]++;
		cnt++;
		right++;

		if(typeCount()) {
			type[tang[left]]--;
			left++;
			cnt--;
		}

		max = Math.max(max, cnt);

		return twoPointer();
	}

	private static boolean typeCount() {
		int cnt = 0;
		for(int num : type) {
			if (num > 0) cnt++;
		}
		return cnt > 2;
	}

}