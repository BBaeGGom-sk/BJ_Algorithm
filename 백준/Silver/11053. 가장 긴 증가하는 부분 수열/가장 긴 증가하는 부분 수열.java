import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, top;
    static int[] DP, nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        top = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        DP = new int[N];
        for(int i = 0; i < N; i++) {
            DP[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(nums[i] < nums[j]) {
                    DP[j] = Math.max(DP[j], DP[i] + 1);
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            top = Math.max(top, DP[i]);
        }

        System.out.println(top);
    }

}