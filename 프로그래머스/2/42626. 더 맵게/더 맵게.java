import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K && pq.size() >= 2){
            int first = pq.poll();
            int second = pq.poll();
            answer++;
            pq.add(first + (second * 2));
        }
        
        // 원소가 하나거나, 없거나
        if(pq.peek() < K || pq.size() == 0){
            answer = -1;
        }
        
        return answer;
    }
}