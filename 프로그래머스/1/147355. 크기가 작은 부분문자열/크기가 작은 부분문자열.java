class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int st = 0;
        int ed = p.length();
        long pNum = Long.parseLong(p);
        long tNum;
        
        while(ed <= t.length()){
            tNum = Long.parseLong(t.substring(st,ed));
            
            if(tNum <= pNum){
                answer++;
            }
            st++;
            ed++;
        }
        
        return answer;
    }
}