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
            
            if(cnt == 0 && st > number.length - 3){
                break;
            }
            
            cnt++;
            sum += number[i];
            
            DFS(i+1, cnt);
            
            cnt--;
            sum -= number[i];
        }
    }
}