import java.util.*;
import java.lang.*;

class Solution {
    
    static int cnt, answer;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE; 
        cnt = 0;
        visited = new boolean[words.length];
        boolean flag = false;
        
        for(String word : words) {
            if(word.equals(target)) flag = true;
        }
        
        if(flag) {
            DFS(begin, target, words);
        
            if(answer == Integer.MAX_VALUE) return 0;
            return answer;
        } else {
            return 0;
        }
        
    }
    
    private void DFS(String begin, String target, String[] words) {
        
        if(begin.equals(target)) {
            answer = Math.min(cnt, answer);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!visited[i]) {
                String word = words[i];
                int unsame = 0;
                for(int j = 0; j < begin.length(); j++) {
                    if(begin.charAt(j) != word.charAt(j)) {
                        unsame++;
                    }
                }
                if(unsame == 1) {
                    cnt++;
                    visited[i] = true;
                    DFS(word, target, words);
                    visited[i] = false;
                    cnt--;
                }
            }
        }
    }
}