import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character,Integer> recentIndex = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            int idx = recentIndex.getOrDefault(s.charAt(i), -1);
            if(idx != -1){
                answer[i] = i - idx;
            } else {
                answer[i] = idx;
            }
            recentIndex.put(s.charAt(i), i);
        }
        
        return answer;
    }
}