class Solution {
    
    int k;
    int answer;
    int[][] dungeons;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        visited = new boolean [dungeons.length];
        permute(0,new int[dungeons.length]);
        
        return this.answer;
    }
    
    public void permute(int now, int[] ar){
        if(now == ar.length) {
            // 순서대로
            int health = this.k;
            int sum = 0;
            int cnt = 0;
            for(int i = 0; i < ar.length; i++){
                int minH = dungeons[ar[i]][0];
                int useH = dungeons[ar[i]][1];
                
                if(health < minH){
                    continue;                    
                }
                
                health -= useH;
                cnt++;
            }
            answer = Math.max(cnt, answer);
            return;
        }
        
        for(int i = 0; i < ar.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            ar[now] = i;
            permute(now+1, ar);
            ar[now] = -1;
            visited[i] = false;
        }
    }
}