import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {1,1};
        
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        
        IntStream.rangeClosed(1,min).forEach(x -> {
            if(min % x == 0 && max % x == 0){
                answer[0] = x;
            }
        });
        
        int st1 = 1;
        int st2 = 1;
        
        while(st1 <= max){
            int minMul = min * st1;
            int maxMul = max * st2;
            if(minMul < maxMul){
                st1++;
            } else if (minMul > maxMul ){
                st2++;
            } else {
                answer[1] = maxMul;
                break;
            }
        }

        return answer;
    }
}