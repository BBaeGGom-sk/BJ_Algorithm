import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min, max;
	static int[] trees;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = 0;
		max = Integer.MIN_VALUE;
		trees = new int[N];

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			trees[i] = temp;
			max = Math.max(temp, max);
		}

		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;

			for(int tree : trees) {
				if (tree - mid > 0) sum += tree - mid;
			}

			if(sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);


	}



}