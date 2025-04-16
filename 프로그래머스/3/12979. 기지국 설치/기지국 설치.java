class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int now = 1;
        
        for(int i = 0; i < stations.length; i++){
            if(stations[i] - w > now){
                answer++;
                now += w * 2 + 1;
                i--;
            } else if (stations[i] + w < now){
                answer++;
                now += w * 2 + 1;
            } else {
                now = stations[i] + w + 1;
            }
        }
        
        while(now < n){
            now += 2 * w + 1;
            answer++;
        }
        if(now == n) {
            answer++;
        }

        return answer;
    }
}