import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        int best = 0;
        int worst = 0;
        
        ArrayList<Integer> winList = new ArrayList<Integer>();
        
        for(int i : win_nums){
            winList.add(i);
        }

        for(int i = 0; i < lottos.length; i++){
            
            int number = lottos[i];
            
            if(number == 0){
                best++;
                continue;
            }
            
            if(winList.contains(number)){
                best++;
                worst++;
            }
        }
        
        answer = new int[] {rank(best), rank(worst)};
        return answer;
    }
    
    public int rank(int num){
        return Math.min(7 - num,6);
    }
}