import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Map<Character, int[]> move = new HashMap<>();
        move.put('U', new int[] {1,0});
        move.put('R', new int[] {0,1});
        move.put('D', new int[] {-1,0});
        move.put('L', new int[] {0,-1});
        
        Set<String> visited = new HashSet<>();
        int[] now = new int[] {0, 0};
        for(int i = 0; i < dirs.length(); i++){
            int[] direct = move.get(dirs.charAt(i));
            
            String st = now[0] + "," + now[1];
            int newX = now[0] + direct[0];
            int newY = now[1] + direct[1];
            
            if(newX < -5 || newX > 5 || newY < -5 || newY > 5 )
                continue;
            
            now[0] = newX;
            now[1] = newY;
            String ed = now[0] + "," + now[1];
            // 시작점-도착점
            // 도착점-시작점
            visited.add(st + "-" + ed);
            visited.add(ed + "-" + st);
        }
        return visited.size()/2;
    }
}