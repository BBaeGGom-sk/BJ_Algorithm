import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayDeque<Integer> q;
		ArrayDeque<Integer> index_q;

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서 개수
			int M = Integer.parseInt(st.nextToken()); // 찾아야 할 인덱스 번호
			q = new ArrayDeque<>();
			index_q = new ArrayDeque<>();

			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) { // 큐에 넣기
				q.add(Integer.parseInt(st.nextToken()));
				index_q.add(j);
			}

			int cnt = 1;
			loop: while (!q.isEmpty())  {
				int curPri = q.peek();
				int curIdx = index_q.peek();
				for(int a = 0; a < q.size(); a++) {
					q.addLast(q.pollFirst());
					index_q.addLast(index_q.pollFirst());
					if(q.peek() > curPri && index_q.peek() != curIdx) {
						continue loop;
					}
				}
				if(curIdx == M) {
					sb.append(cnt).append("\n");
					break;
				} else {
					q.pollFirst();
					index_q.pollFirst();
					cnt++;
				}
			}
		}
		System.out.println(sb);
		br.close();

	}
}