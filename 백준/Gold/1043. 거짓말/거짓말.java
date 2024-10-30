import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, cnt, truthMemberNum, truthParent;
    static int[] parent, truthMembers;
    static int[][] party;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        cnt = 0;

        for(int i = 0; i < N+1; i++) { // 초기화
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        truthMemberNum = Integer.parseInt(st.nextToken());
        if(truthMemberNum == 0) {
            System.out.println(M);
        } else {
            truthParent = 0;
            truthMembers = new int[truthMemberNum];
            for(int i = 0; i < truthMemberNum; i++) {
                truthMembers[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < truthMemberNum-1; i++) {
                union(truthMembers[i], truthMembers[i+1]);
            }
            truthParent = truthMembers[0];

            party = new int[M][];
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                party[i] = new int[Integer.parseInt(st.nextToken())];
                for(int j = 0; j < party[i].length; j++) {
                    party[i][j] = Integer.parseInt(st.nextToken());
                }
                for(int j = 0; j < party[i].length-1; j++) {
                    union(party[i][j], party[i][j+1]);
                }
            }

            for(int i = 0; i < M; i++) {
                boolean flag = false;
                for(int j = 0; j < party[i].length; j++) {
                    if(find(party[i][j]) == truthParent) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            if(x == truthParent) parent[y] = x;
            else if(y == truthParent) parent[x] = y;
            else parent[y] = x;
        }
    }

}