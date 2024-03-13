import java.util.*;

class Solution {
    
    Map<String,Integer> wordMap = new HashMap<>();
    
    public Solution(){
        int st = 0;
        wordMap.put("zero",st++);
        wordMap.put("one",st++);
        wordMap.put("two",st++);
        wordMap.put("three",st++);
        wordMap.put("four",st++);
        wordMap.put("five",st++);
        wordMap.put("six",st++);
        wordMap.put("seven",st++);
        wordMap.put("eight",st++);
        wordMap.put("nine",st++);
    }
    
    public int solution(String s) {
        int answer = 0;
        String word = "";
        StringBuilder answerStr = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            
            if(!Character.isDigit(s.charAt(i))){
                word += s.charAt(i);
            } else {
                answerStr.append(s.charAt(i));
            }
            
            if(wordMap.containsKey(word)){
                answerStr.append(wordMap.get(word));
                word = "";
            }
            
        }
        
        return Integer.parseInt(answerStr.toString());
    }
}