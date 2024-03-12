import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {1,1};
        
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        
        IntStream.rangeClosed(1,min).forEach(x -> {
            if(min % x == 0 && max % x == 0){
                answer[0] = x;
                answer[1] = n * m / answer[0];
            }
        });
        

        return answer;
    }
}