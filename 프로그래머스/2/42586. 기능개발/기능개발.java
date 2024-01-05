import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;



class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 1;
        int releasedProgress = 0;
        Map<Integer,Integer> releaseNote = new LinkedHashMap<>();
        Queue<Integer> progressesQue = new LinkedList<>();

        for (int progress: progresses) {
            progressesQue.offer(progress);
        }
        
        while(!progressesQue.isEmpty()){
            if (progressesQue.peek()+speeds[releasedProgress]*day >= 100){
                progressesQue.poll();
                releasedProgress++;
                if(releaseNote.containsKey(day)){
                    releaseNote.put(day,releaseNote.get(day)+1);
                } else {
                    releaseNote.put(day,1);
                }
                continue;
            }
            day++;
        }

        int[] answer = releaseNote.values().stream().mapToInt(n->n).toArray();

        return answer;
    }
}