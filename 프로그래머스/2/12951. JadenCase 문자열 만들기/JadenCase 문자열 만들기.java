import java.util.Arrays;
class Solution {
       public String solution(String s) {
        String answer = "";
        char[] sToArray = s.toLowerCase().toCharArray();
        boolean flag = true;

        for (char ch: sToArray) {
            answer += flag ? Character.toUpperCase(ch) : ch;
            flag = ch == ' ' ? true : false;
        }
        return answer;
    }
}