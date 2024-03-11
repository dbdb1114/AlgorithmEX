import java.util.*;

class Solution {
    public int solution(int num) {
        int answer = 0;
        while(num != 1 && answer < 500){
            if(num % 2 == 0){ // 짝수
                num /= 2;
            } else if ( num % 2 == 1 ) { // 홀수
                num *= 3;
                num += 1;
            }
            answer ++;
        }
        
        if(answer >= 500){
            answer = -1;
        }
        return answer;
    }
}