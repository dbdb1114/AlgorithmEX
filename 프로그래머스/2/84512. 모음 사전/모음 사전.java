import java.util.*;

class Solution {
    String[] diction = {"A", "E", "I", "O", "U"};
    int cnt = 0;
    int answer = 0;
    public int solution(String word) {        
        tracking(word, new StringBuilder());
        return answer;
    }
    
    public void tracking(String target, StringBuilder word) {
        if( target.equals(word.toString()) ) {
            answer = cnt;
            return ;
        }
        
        if(word.length() == 5){
            return;
        }
        
        for(int i = 0; i < 5; i++){
            cnt++;
            word.append(diction[i]);
            tracking(target, word);
            word.deleteCharAt(word.length()-1);
        }
        
    }
}