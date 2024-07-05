import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Long[] top;
	static Map<Long, Long> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		top = new Long[] {0L,0L};

		for(int i = 0; i < N; i++) {
			Long temp = Long.parseLong(br.readLine());
			Long newValue = (map.getOrDefault(temp, 0L) + 1);
			map.put(temp, newValue);

			if(top[0] < newValue) {
				top[0] = newValue;
				top[1] = temp;
			} else if(top[0].equals(newValue)) {
				top[1] = Math.min(top[1],temp);
			}
		}

		System.out.println(top[1]);

	}

}