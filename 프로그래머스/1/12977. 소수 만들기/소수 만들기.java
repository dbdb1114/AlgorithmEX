class Solution {
    int sum = 0;
    int answer = 0;
    int nums[];
    
    public int solution(int[] nums) {
        this.nums = nums;
        recursive(0,0);
        return answer;
    }
    
    public void recursive(int st, int cnt){
        if(cnt == 3){
            if(isSosu(sum)){
                answer++;
            }
            return;
        }
        
        for(int i = st; i < nums.length; i++){
            
            if(cnt == 0 && st > nums.length - 3){
                break;
            }
            
            cnt++;
            sum += nums[i];
            
            recursive(i+1, cnt);
            
            cnt--;
            sum -= nums[i];
        }
    }
    
    
    public boolean isSosu(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}