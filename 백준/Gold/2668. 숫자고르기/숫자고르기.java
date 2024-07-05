import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N,cnt;
	static int[] arr;
	static boolean[] visited,answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		answer = new boolean[N+1];
		cnt = 0;

		for(int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 1; i < arr.length; i++) {
			if(!answer[i]) {
				visited = new boolean[N+1];
				returnCheck(i,i);
			}
		}

		for(int i = 0; i < answer.length; i++) {
			if(answer[i]) {
				cnt++;
				sb.append(i).append("\n");
			}
		}

		sb.insert(0,cnt+"\n");
		System.out.println(sb);

	}

	private static void returnCheck(int i,int firstNum) {
		if(!visited[i]) {
			visited[i] = true;
			returnCheck(arr[i],firstNum);
		} else {
			if (i == firstNum) {
				answer[i] = true;
			}
		}
	}


}