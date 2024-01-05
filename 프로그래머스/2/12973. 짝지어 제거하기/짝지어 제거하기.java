import java.util.Stack;

class Solution
{
        public static void stackCheck(Stack<Character> temp, char ch){
        if(temp.isEmpty()){
            temp.push(ch);
        } else if ( temp.peek() == ch){
            temp.pop();
        } else {
            temp.push(ch);
        }
    }

    public static int solution(String alphabet) {

        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < alphabet.length(); i++) {
            stackCheck(temp, alphabet.charAt(i));
        }

        return temp.isEmpty() ? 1 : 0;
    }
    
}