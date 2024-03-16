/**
고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다.

    약관 종류는 여러 가지이며, 
    개인정보 보관 유효기간이 있음 
    수집된 개인정보는 유효기간 전까지만 보관 가능하며, 
    유효기간이 지났다면 반드시 파기해야 합니다.
    
예제 
A라는 약관의 유효기간이 12 달이고
2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면
해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기 
    ==> 만날짜로 체크한다. 



제한사항 
모든 달은 28일까지 있다고 가정합니다.

오늘 날짜를 의미하는 문자열 today
["YYYY.MM.DD" 형태로 오늘 날짜를 나타냅니다.]

약관의 유효기간을 담은 1차원 문자열 배열 terms 
["약관 종류 유효기간" 형태의 약관 종류와 유효기간을 공백 하나로 구분한 문자열]

수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies
["날짜 약관종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자열]

이때 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 

제한 사항
today는 "YYYY.MM.DD
*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    Calendar now = Calendar.getInstance();;
    Calendar target = Calendar.getInstance();;

    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException{
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Character, Integer> termsMap = new HashMap<>();
        
        now.setTime(new SimpleDateFormat("yyyy.MM.dd").parse(today));

        for(String condition : terms){
            char name = condition.charAt(0);
            Integer stDate = Integer.parseInt(condition.substring(2));
            termsMap.put(name, stDate);
        }

        for(int i = 0; i < privacies.length; i++){
            String privacy = privacies[i];

            char name = privacy.charAt(privacy.length() - 1);
            String stDate = privacy.substring(0,10);

            int limit = termsMap.get(name);

            if(isValid(limit, stDate)){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }

    public boolean isValid(int period, String stDate) throws ParseException {
        target.setTime(new SimpleDateFormat("yyyy.MM.dd").parse(stDate));
        target.add(Calendar.MONTH, period);
        if(stDate.equals("2022.02.19")){
            System.out.println(target.getTime());    
            System.out.println(now.getTime());                
        }
        return !target.after(now);
    }
}