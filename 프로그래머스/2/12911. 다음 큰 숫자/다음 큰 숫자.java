import java.util.Arrays;


class Solution {

    public int solution(int n) {
        boolean flag = true;

        int answer = n;
        int numberOfOne = Integer.bitCount(n);

        while (flag){
            answer = answer + 1;
            if(numberOfOne == Integer.bitCount(answer)){
                flag = false;
            }
        }
        return answer;
    }

}