import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static LinkedHashSet<String> set;
    static boolean[] visited;
    static ArrayList<Integer> list,nums;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new LinkedHashSet<>();
        nums = new ArrayList<>();
        visited = new boolean[N];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);

        BackTracking(0);

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }



    }

    private static void BackTracking(int depth) {
        if(depth == M) {
            sb = new StringBuilder();
            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(nums.get(i));
                BackTracking(depth+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }


    }

}