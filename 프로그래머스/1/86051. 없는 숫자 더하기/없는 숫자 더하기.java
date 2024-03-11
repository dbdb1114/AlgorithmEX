import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int i = 0; i < numbers.length; i++){
            answer -= numbers[i];
        }
        answer = answer == 0 ? -1 : answer;
        return answer;
    }
}