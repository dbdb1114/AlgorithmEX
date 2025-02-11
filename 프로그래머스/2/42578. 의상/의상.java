import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        // 키별 갯수 + 1 
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(!map.containsKey(clothes[i][1])){
                map.putIfAbsent(clothes[i][1], 0);    
            }
            map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }
        
        answer = map.keySet().stream()
            .map(key -> map.get(key) + 1)
            .reduce(1,(x,y)->x*y);
        return answer - 1;
    }
}