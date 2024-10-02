import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static long A, B, curNum;
    static int cnt;
    static Map<Long,Integer> map;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        cnt = 0;
        curNum = A;
        map = new HashMap<>();
        map.put(B,-1);
        DFS();

        System.out.println(map.getOrDefault(B,-1));
    }

    private static void DFS() {
        if(curNum == B) {
            if(map.get(B) == -1) {
                map.put(B,cnt+1);
            } else {
                map.put(B,Math.min(map.get(B),cnt+1));
            }
            return;
        }

        long temp = curNum*2;
        if(temp <= B) {
            curNum = temp;
            cnt++;
            DFS();
            cnt--;
            curNum /= 2;
        }

        temp = curNum*10+1;
        if(temp <= B) {
            curNum = temp;
            cnt++;
            DFS();
            cnt--;
            curNum = (curNum-1)/10;
        }
    }
}