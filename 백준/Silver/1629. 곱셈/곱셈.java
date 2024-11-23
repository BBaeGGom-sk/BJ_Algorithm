import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int A, B, C;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(modExp(A,B,C));

    }

    private static int modExp(int a, int b, int c) {
        if(b == 0) return 1;
        long half = modExp(a,b/2,c);

        half = (half * half) % c; // 짝수

        if(b % 2 != 0) { // 홀수
            half = (half * a) % c;
        }

        return (int) half;
    }


}

