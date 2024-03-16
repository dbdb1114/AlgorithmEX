import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] ftSupo = {1,2,3,4,5};
        int[] scSupo = {2,1,2,3,2,4,2,5};
        int[] thSupo = {3,3,1,1,2,2,4,4,5,5};
        
        int[] answerRecord = {0,0,0};
        
        for(int i = 0; i < answers.length; i++){
            answerRecord[0] = ftSupo[i%5] == answers[i] ? answerRecord[0] + 1 : answerRecord[0];
            answerRecord[1] = scSupo[i%8] == answers[i] ? answerRecord[1] + 1 : answerRecord[1];
            answerRecord[2] = thSupo[i%10] == answers[i] ? answerRecord[2] + 1 : answerRecord[2];
        }
        
        System.out.println(Arrays.toString(answerRecord));
        
        int max = Arrays.stream(answerRecord).max().getAsInt();
        answer = IntStream.range(1,4).filter(x -> answerRecord[x-1] >= max).toArray();
        return answer;
    }
}