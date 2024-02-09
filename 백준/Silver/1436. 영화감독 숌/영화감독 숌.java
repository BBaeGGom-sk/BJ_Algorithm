import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // n번째로 작은 종말의 수
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;

		for(int i = 666; i < Integer.MAX_VALUE; i++) {
			if(String.valueOf(i).contains("666")) {
				list.add(i);
				if(++count == N) {
					break;
				}
			}
		}

		Collections.sort(list);
		System.out.println(list.get(N-1));

		br.close();

	}
}