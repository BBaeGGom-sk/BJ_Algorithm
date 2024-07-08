import java.util.*;

class Solution {
    
    static int[] answer;
    static ArrayList<Integer>[] roadList;
    static ArrayDeque<Soldier> q;
    static boolean[] visited;
    static int[] dis;
    static class Soldier {
        int num;
        int time;
        
        Soldier(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        answer = new int[sources.length];
        roadList = new ArrayList[n+1];
        dis = new int[n+1];
        Arrays.fill(dis, -1);
        
        for (int i = 0; i <= n; i++) {
            roadList[i] = new ArrayList<>();
        }
        
        for(int[] road : roads) {
            roadList[road[0]].add(road[1]);
            roadList[road[1]].add(road[0]);
        }
        
        BFS(destination, n);
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = dis[sources[i]];
        }
        
        
        return answer;
    }
    
    
    private static void BFS(int start, int m) {
        q = new ArrayDeque<>();
        q.add(new Soldier(start, 0));
        dis[start] = 0;
        
        while(!q.isEmpty()) {
            Soldier soldier = q.poll();
            
            for(int i = 0; i < roadList[soldier.num].size(); i++) {
                int next = roadList[soldier.num].get(i);
                if(dis[next] == -1) {
                    dis[next] = soldier.time + 1;
                    q.add(new Soldier(next, dis[next]));    
                }
                
            }
        }
    }
    
    
}

