import java.util.Stack;

class Solution {
    boolean solution(String s) {
         boolean answer = true;
        Stack<Character> sStack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') {
                sStack.push(ch);
            } else if (!sStack.isEmpty()){
                sStack.pop();
            } else {
                answer = false;
                break;
            }
        }

        if(!sStack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}