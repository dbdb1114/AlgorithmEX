import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        for(int[] water : puddles){
            dp[water[1] - 1][water[0] - 1] = -1;
        }
        
        for(int i = 1; i < n; i++){
            if(dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < m; i++){
            if(dp[0][i] == -1) break;
            dp[0][i] = 1;
        }
        
        for(int j = 1; j < n; j++){
            for(int i = 1; i < m; i++){
                if(dp[j][i] == -1) continue;
                if(dp[j-1][i] == -1){
                    dp[j][i] = (dp[j][i-1])% 1000000007;
                } else if(dp[j][i-1] == -1){
                    dp[j][i] = (dp[j-1][i])% 1000000007;
                } else {
                    dp[j][i] = (dp[j-1][i] + dp[j][i-1])% 1000000007;
                }
            }    
        }
        
        return dp[n-1][m-1] % 1000000007;
    }
}