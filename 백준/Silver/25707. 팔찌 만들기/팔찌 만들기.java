import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static Long sum;
	static ArrayList<Long> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		br.readLine();
		sum = 0L;
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			list.add(Long.parseLong(st.nextToken()));
		}

		list.sort(Collections.reverseOrder());

		for(int i = 0; i < list.size()-1; i++) {
			sum += list.get(i) - list.get(i+1);
		}

		sum += list.get(0) - list.get(list.size()-1);

		System.out.println(sum);
	}

}