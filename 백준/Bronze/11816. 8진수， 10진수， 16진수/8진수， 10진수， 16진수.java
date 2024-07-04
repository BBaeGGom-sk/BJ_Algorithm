import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		X = br.readLine();
		if(X.charAt(0) == '0') {
			if(X.charAt(1) == 'x') { // 16진수
				System.out.println(Integer.parseInt(X.substring(2),16));
			} else { // 8진수
				System.out.println(Integer.parseInt(X.substring(1),8));
			}
		} else { // 10진수
			System.out.println(Integer.parseInt(X));
		}


	}

}