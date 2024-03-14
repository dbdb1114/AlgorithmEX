class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int totCoke = 0;
        
        while(n >= a){
            int leftBottle = (n % a);
            int newCola = (n / a) * b;
            n = newCola + leftBottle;
            totCoke += newCola;
        }

        return totCoke;
    }
}