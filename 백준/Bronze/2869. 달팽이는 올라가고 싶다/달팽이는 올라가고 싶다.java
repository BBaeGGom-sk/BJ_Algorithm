import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int target = V - B; // 기준값 = 정상 - 하루 내려가는 양 (내려가기전에 정상에 도착했을 경우를 고려)
		int dailyUp = A - B; // 하루에 총 올라가는 양 = 올라가는 양 - 내려가는 양
		int day = target / dailyUp; // 소요일 수 계산
		if(target % dailyUp != 0) day++; // 주의: 나머지 발생 시 올림해서 계산해야함

		System.out.println(day);
		br.close();

	}
}