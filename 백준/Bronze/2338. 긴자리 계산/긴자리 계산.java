import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static BigInteger A,B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st;

		A = new BigInteger(br.readLine());
		B = new BigInteger(br.readLine());

		sb.append(A.add(B)).append("\n");
		sb.append(A.subtract(B)).append("\n");
		sb.append(A.multiply(B)).append("\n");

		System.out.println(sb);
	}

}