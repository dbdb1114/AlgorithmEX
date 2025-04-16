import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, Integer.MAX_VALUE};
        // gems 의 종류 
        Set<String> gemSet = new HashSet<>();
        for(String gem : gems){
            gemSet.add(gem);
        }
        
        // 짧은 구간 탐색
        // 투 포인터를 활용하여, Map에 저장한다. 
        // 탐색하며, Map에 구간내 gem별 탐색 갯수를 최신화하고,
        // 탐색 완료시 시작 포인터를 증가시켜, gem을 감소시킨다.
        
        int lt = 0;
        int rt = 0;
        Map<String, Integer> gemMap = new HashMap<>();
        gemMap.put(gems[rt], 1);
        while(lt <= rt && rt < gems.length){
            if(gemMap.size() == gemSet.size()){
                if(rt - lt < answer[1] - answer[0]){
                    answer = new int[] {lt + 1, rt + 1};
                }
                if(gemMap.containsKey(gems[lt]) && gemMap.get(gems[lt]) > 1) {
                    gemMap.put(gems[lt], gemMap.get(gems[lt]) - 1);
                } else {
                    gemMap.remove(gems[lt]);
                }
                lt++;
            } else {
                rt++;
                if(rt >= gems.length) break;
                gemMap.putIfAbsent(gems[rt], 0);
                gemMap.put(gems[rt], gemMap.get(gems[rt]) + 1);
            }
        }
        
        return answer;
    }
}