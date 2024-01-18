import java.util.*;
/**
        최소공배수란? 
        서로 다른 수들의 곱 중 가장 작은 것.
        
        나눌 수 있으면 큰 수가 최소공배수이고, 
        
        나눌 수 없다면, 두 수를 곱하고, 두 수의 공약수로 해당 수를 나눔
*/

class Solution {
    
    public int maxDivideNumber(int a, int b){
        if(b % a == 0) {
            return a;
        } 
        return maxDivideNumber(b % a, a);
    }
    
    public int solution(int[] arr) {
        
        int answer = 1;
        Arrays.sort(arr);
        
        for(int i = arr.length - 1; i > 0; i--){
            for(int j = i - 1; j >= 0 ; j--){
                int commonDivied = maxDivideNumber(arr[i], arr[j]);
                arr[j] = arr[j] / commonDivied;
            }
            answer *= arr[i];
        }

        return answer;
    }
}