import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int[][] storageMap = new int[storage.length+2][storage[0].length()+2];
        for(int i = 0; i < storage.length ; i++){
            for(int j = 0; j < storage[i].length(); j++){
                storageMap[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(int i = 0; i < requests.length; i++){
            if(requests[i].length() > 1){
                findoutAll(storageMap, requests[i].charAt(0));
            } else {
                findoutSide(storageMap, requests[i].charAt(0));
            }
            
        }
        
        for(int i = 0; i < storageMap.length; i ++){
            for(int j = 0; j < storageMap[i].length; j++){
                if(storageMap[i][j]!= 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public void findoutSide(int[][] arr, char tar){
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0,0});
        int find = 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        
        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        
        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int nowX = cur[0];
            int nowY = cur[1];
            
            for(int i = 0; i < 4; i++){
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if(newX < 0 || newX >= arr.length 
                   || newY < 0 || newY >= arr[0].length || visited[newX][newY]){
                    continue;
                }
                
                if(arr[newX][newY] == 0){
                    visited[newX][newY] = true;
                    qu.add(new int[] {newX,newY});
                }
                
                if(arr[newX][newY] == tar){
                    visited[newX][newY] = true;
                    arr[newX][newY] = 0;
                }
            }
            
        }
    }
    
    public void findoutAll(int[][] arr, char tar){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == tar){
                    arr[i][j] = 0;
                }
            }
        }
    }
}