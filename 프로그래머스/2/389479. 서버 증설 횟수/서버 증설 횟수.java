import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        for(int i = 0; i < players.length; i++){
            int server = players[i]/m;
            if(servers[i] < server){
                int need = server - servers[i];
                for(int j = i; j <= Math.min(i + k - 1, 23); j++){
                    servers[j] += need;
                }
                answer += need;
            }
        }
        
        
        return answer;
    }
}