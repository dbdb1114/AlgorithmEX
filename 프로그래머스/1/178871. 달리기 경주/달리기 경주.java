/**
    얀에서는 매년 달리기 경주가 열립니다. 
    해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 
    
    예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
    해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 
        
    선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players
    해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때
    
    1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
*/
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> playerPos = new HashMap<>();
        
        // 매번 플레이어의 위치를 찾지 않기 위해 위치 기록용
        for(int i = 0; i < players.length; i++){
            playerPos.put(players[i],i);
        }
        
        for(String overTaker : callings){
            overTaking(overTaker, playerPos, players);
        }
        
        return players;
    }
    
    public void overTaking(String overTaker,Map<String, Integer> playerPos, String[] players){
        int pos = playerPos.get(overTaker);
        
        String takenOver = players[pos - 1];
        
        // 위치 최신화 
        playerPos.put(overTaker, playerPos.get(overTaker) - 1);
        playerPos.put(takenOver, playerPos.get(takenOver) + 1);
        
        // 위치 최신화
        String temp = players[pos - 1];
        players[pos - 1] = overTaker;
        players[pos] = temp;    
    }
    
}