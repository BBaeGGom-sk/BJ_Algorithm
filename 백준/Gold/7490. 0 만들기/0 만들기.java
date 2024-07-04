import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T,N;
	static StringBuilder sb, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		answer = new StringBuilder();

		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			sb.append("1");
			makeExpression(2);

			answer.append("\n");
		}

		System.out.println(answer);

	}

	private static void makeExpression(int i) {
		if(i > N) {
			calc();
			return;
		}

		sb.append(" ").append(i);
		makeExpression(i+1);
		sb.delete(sb.length()-2, sb.length());

		sb.append("+").append(i);
		makeExpression(i+1);
		sb.delete(sb.length()-2,sb.length());

		sb.append("-").append(i);
		makeExpression(i+1);
		sb.delete(sb.length()-2,sb.length());
	}

	private static void calc() {
		String expression = sb.toString();
		int result = 0;
		int temp = 0;
		boolean sign = true;

		for(int i = 0; i < expression.length(); i++) {
			char letter = expression.charAt(i);
			if(Character.isDigit(letter)) {
				temp *= 10;
				temp += letter-'0';
			} else if(letter == '+') {
				if(sign) result += temp;
				else result -= temp;

				temp = 0;
				sign = true;
			} else if(letter == '-') {
				if(sign) result += temp;
				else result -= temp;

				temp = 0;
				sign = false;
			}

			if(i == expression.length()-1) {
				if(sign) result += temp;
				else result -= temp;

				if(result == 0) {
					answer.append(sb).append("\n");
				}
			}
		}

	}

}