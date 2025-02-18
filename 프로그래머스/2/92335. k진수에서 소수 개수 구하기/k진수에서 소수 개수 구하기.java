import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        String nInK = Long.toString(n,k);
        
        answer = Arrays.stream(nInK.split("0"))
            .map(str->str.trim())
            .filter(str->str.length() > 0)
            .mapToLong(Long::parseLong)
            .filter(num -> isPrime(num))
            .toArray().length;
        
        return answer;
    }
    
    public boolean isPrime(long n){
        if(n == 1) return false;
        for(long i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}