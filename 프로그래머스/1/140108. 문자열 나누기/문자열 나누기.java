/**
문자열 s가 입력되었을 때 다음 규칙을 따라서 
이 문자열을 여러 문자열로 분해하려고 합니다.

먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.

이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, 
x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 

처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.

s에서 분리한 문자열을 빼고 
남은 부분에 대해서 이 과정을 반복합니다. 
남은 부분이 없다면 종료합니다.

만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 
역시 지금까지 읽은 문자열을 분리하고, 종료합니다.

*/
import java.util.*;


class Solution {
    public int solution(String s) {
        int answer = 0;

        Map<String, Integer> numbering = new HashMap<>();

        int sIdx = 0;
        int stChar = s.charAt(0);

        numbering.put("x", 0);
        numbering.put("other", 0);
        int cnt=0;
         while (sIdx < s.length()){

            if(s.charAt(sIdx) == stChar){
                numbering.put("x", numbering.get("x") + 1);
            } else {
                cnt++;
                numbering.put("other", numbering.get("other") + 1);
            }

            sIdx++; // 2 4

            if(numbering.get("x") == cnt){
                answer++;
                if(sIdx < s.length()){
                    stChar = s.charAt(sIdx); // n n

                    numbering.put("x" ,1);
                    numbering.put("other", 0);


                    cnt = 0;
                    sIdx++; // 3 5
                }else{
                    break;
                }
            }

        }       
        if(numbering.get("x") != numbering.get("other")){
            answer++;
        }

        
        return answer;
    }

}