import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		if(N == 0) {
			System.out.println(0);
		} else {
			int avg = (int)Math.round(N*0.15);
			int sum = 0;
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(br.readLine()));
			}
			Collections.sort(list);
			for(int i = avg; i < list.size()-avg; i++) {
				sum += list.get(i);
			}
			System.out.println(Math.round(sum / ((N-(2*avg))*1.0) ));
		}

		br.close();

	}
}