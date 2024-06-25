import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static int T,k;
	static TreeMap<Integer, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		StringTokenizer st;



		T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			k = Integer.parseInt(br.readLine());
			map = new TreeMap<>();
			for(int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				Command(st);
			}

			System.out.println(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey());
		}


	}

	private static void Command(StringTokenizer st) {
		String order = st.nextToken();
		int num = Integer.parseInt(st.nextToken());

		if(order.equals("I")) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		} else {
			if(!map.isEmpty()) {
				int key = (num == 1 ? map.lastKey() : map.firstKey());
				int cnt = map.getOrDefault(key, 0);

				if(cnt == 1) map.remove(key);
				else if(cnt > 1) map.put(key, cnt-1);
			}
		}
	}

}