import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        br.readLine();
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new TreeSet<>(new ArrayList<Integer>(list));
        Iterator<Integer> iter = set.iterator();
        for(int idx = 0; iter.hasNext(); idx++) {
            map.put(iter.next(),idx);
        }

        for(int element : list) {
            sb.append(map.get(element)).append(" ");
        }

        System.out.println(sb);
        br.close();

    }
}