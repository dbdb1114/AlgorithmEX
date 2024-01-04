import  java.util.StringTokenizer;

class Solution {
    public int[] solution(String s) {
 
        int numberOfChange = 0;
        int numberOfZero = 0;

        int[] answer = new int[2];

        while(!"1".equals(s)){
            int prevLength = s.length();
            s = s.replace("0","");
            numberOfZero += prevLength - s.length();
            s = Integer.toBinaryString(s.length());
            numberOfChange++;
        }

        answer[0] = numberOfChange;
        answer[1] = numberOfZero;
        
        return answer;
    }
    
}