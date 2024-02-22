import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		while (!str.equals(".")) {
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				} else if(str.charAt(i) == ')') {
					if(!stack.empty() && stack.peek() == '(') {
						stack.pop();
					} else {
						sb.append("no").append("\n");
						break;
					}
				} else if(str.charAt(i) == ']') {
					if(!stack.empty() && stack.peek() == '[') {
						stack.pop();
					} else {
						sb.append("no").append("\n");
						break;
					}
				} else if(str.charAt(i) == '.') {
					if(stack.empty()) {
						sb.append("yes").append("\n");
					} else {
						sb.append("no").append("\n");
					}
				}
			}
			str = br.readLine();
		}
		System.out.println(sb);
		br.close();

	}
}