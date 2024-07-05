import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int H,W,X,Y;
	static int[][] A,B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		A = new int[H][W];
		B = new int[H+X][W+Y];

		for(int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(i-X >= 0 && j-Y >= 0) {
					A[i][j] = B[i][j] - A[i-X][j-Y];
				} else {
					A[i][j] = B[i][j];
				}
			}
		}

		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

}