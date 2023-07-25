class Solution {

    public int solution(int n) {
        int prev1 = 0;
        int prev2 = 1;
        for (int i = 2; i < n; i++){
            int temp = prev1;
            prev1 = prev2%1234567;
            prev2 = (temp + prev2)%1234567;
        }

        int res = (prev1+prev2) % 1234567;
        return res;
    }
}