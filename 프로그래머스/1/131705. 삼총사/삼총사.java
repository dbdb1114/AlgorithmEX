class Solution {
    int[] number;
    boolean[] checkArr;
    int sum;
    int answer;
    
    public int solution(int[] number) {
        
        this.number = number;
        
        DFS(0,0);
        
        return answer;
    }
    
    public void DFS(int st, int cnt){
        if(cnt == 3){
            if(sum == 0){
                answer++;
            }
            return ;
        }
        
        for(int i = st; i < number.length; i++){
            cnt++;
            sum += number[i];
            
            DFS(i+1, cnt);
            
            cnt--;
            sum -= number[i];
        }
    }
}