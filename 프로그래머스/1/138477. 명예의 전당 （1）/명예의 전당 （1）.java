import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        
        for(int i = 0; i < score.length; i++){    
            pr.add(score[i]);
            if(pr.size() > k){
                pr.poll();
            }
            answer[i] = pr.peek();
        }
        
        return answer;
    }
}