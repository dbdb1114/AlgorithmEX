class Solution {
    public int solution(int n, int a, int b) {
        int smallNumber = a > b ? b : a;
        int bigNumber = a > b ? a : b;
        int answer = 1;

        while (true){
            if (smallNumber + 1 == bigNumber && smallNumber % 2 != 0) {
                break;
            }
            smallNumber = nextNumber(smallNumber);
            bigNumber = nextNumber(bigNumber);
            answer++;
        }

        return answer;
    }
    
    public static int nextNumber( int nowNumber ){
        if(nowNumber%2 != 0){
            return Math.round(nowNumber/2) + 1;
        } else {
            return nowNumber/2;
        }
    }
    
}