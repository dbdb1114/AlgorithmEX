class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++){
            int divisor = counting(i);
            if(isOdd(divisor)){
                answer -= i;
            } else {
                answer += i;
            }
        }
        
        return answer;
    }
    
    public boolean isOdd(int num){
        if(num % 2 == 1){
            return true;
        } else {
            return false;
        }
    }
    
    public int counting(int num){
        int cnt = 1;
        
        for(int i = 1; i <= num/2; i++){
            if(num % i == 0) {
                cnt++;
            }
        }
        
        return cnt;
    }
}