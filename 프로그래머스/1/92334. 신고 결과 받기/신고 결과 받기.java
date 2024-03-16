/**
신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다.

각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
    신고 횟수에 제한은 없습니다. 
    서로 다른 유저를 계속해서 신고할 수 있습니다.
    한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.

k번 이상 신고된 유저는 게시판 이용이 정지되며, 
해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
    유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
    
유저별로 받는 메일의 개수가 궁금하다 
    ==> 유저별로 신고한 사람중 정지당한 사람의 수

Map<String, Integer> 신고한 사람들별로 받을 메일 수;

Map<String, Set<String>> 신고 당한 사람 
    신고 당한 유저 : [신고 한 유저들 SET] 

-----

Map<String, Set<String>> 신고 당한 사람 
    신고 당한 유저 : [신고 한 유저들 SET]
 
 if (신고한 유저들 SET >= K)
    해당 SET에 있는 모든 아이디 받을 메일 증가

*/
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> numOfMail = new HashMap<>();
        Map<String, Set<String>> warnUserMap = new HashMap<>();
        
        for(String rep : report){
            String warnId = rep.split(" ")[1];
            warnUserMap.put(warnId, new HashSet<String>());
        }
        
        for(String rep : report){
            String userId = rep.split(" ")[0];
            String warnId = rep.split(" ")[1];
            
            warnUserMap.get(warnId).add(userId);
        }
        
        for(String warnId : warnUserMap.keySet()){
            Set<String> userSet = warnUserMap.get(warnId);
            if(userSet.size() >= k){
                userSet.stream()
                    .forEach(userId -> numOfMail.put(userId, numOfMail.getOrDefault(userId,0) + 1));
            }
        }
        
        for(int i = 0; i < id_list.length; i++){
            answer[i] = numOfMail.getOrDefault(id_list[i],0);
        }
        
        return answer;
    }
}