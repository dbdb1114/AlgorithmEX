class Solution {
    int[] number;
    boolean[] checkArr;
    int sum;
    int answer;
    
    public int solution(int[] number) {
        
        this.checkArr = new boolean[number.length];
        this.number = number;
        
        BFS(0,0);
        
        return answer;
    }
    
    public void BFS(int st, int cnt){
        if(cnt == 3){
            if(sum == 0){
                answer++;
            }
            return ;
        }
        
        for(int i = st; i < number.length; i++){
            checkArr[i] = true;
            cnt++;
            sum += number[i];
            
            BFS(i+1, cnt);
            
            checkArr[i] = false;
            cnt--;
            sum -= number[i];
        }
    }
}