import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		Double A = Double.parseDouble(st.nextToken());
		Double B = Double.parseDouble(st.nextToken());
		Double V = Double.parseDouble(st.nextToken());

		Double target = V - B; // 기준값 = 정상 - 하루 내려가는 양 (내려가기전에 정상에 도착했을 경우를 고려)
		Double dailyUp = A - B; // 하루에 총 올라가는 양 = 올라가는 양 - 내려가는 양
		int day = (int)Math.ceil(target / dailyUp); // 소요 일 수 = (기준값 / 하루 총 올라가는 양)를 반올림
													// int로 형변환하여 정수형으로 출력

		System.out.println(day);
		br.close();

	}
}