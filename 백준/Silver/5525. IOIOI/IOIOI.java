import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, cnt, patternCnt;
    static char[] S;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine().toCharArray();
        cnt = 0;
        patternCnt = 0;

        for(int i = 1; i < M-1; i++) {
             if(S[i-1] == 'I' && S[i] == 'O' && S[i+1] == 'I') {
                 patternCnt++;
                 if(patternCnt == N) {
                     cnt++;
                     patternCnt--;
                 }
                 i++;
             } else {
                 patternCnt = 0;
             }
        }

        System.out.println(cnt);




    }

}