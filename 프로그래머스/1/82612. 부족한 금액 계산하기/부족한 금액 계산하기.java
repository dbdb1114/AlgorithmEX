class Solution {
    public long solution(int price, int money, int count) {
        long totPrice = 0;
        
        for(int i = 1; i <= count; i++){
            totPrice += price * i;
        }

        return Math.max(totPrice - money,0);
    }
} 