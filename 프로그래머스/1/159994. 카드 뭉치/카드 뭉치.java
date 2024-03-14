class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int goalIdx = 0;
        int oneIdx = 0;
        int twoIdx = 0;
        
        while(goalIdx < goal.length){
            
            String target = goal[goalIdx++];
            
            if(oneIdx < cards1.length && cards1[oneIdx].equals(target)){
                oneIdx++;
            } else if(twoIdx < cards2.length && cards2[twoIdx].equals(target)){
                twoIdx++;
            } else {
                answer = "No";
            }
            
        }
        
        return answer;
    }
}