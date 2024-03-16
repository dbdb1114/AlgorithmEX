import java.util.Arrays;

class Solution {
    
    public static String solution(String s){
        String[] numbers = s.split(" ");
        int[] answer = Arrays.stream(numbers).mapToInt(Integer::parseInt).sorted().toArray();
        return answer[0] + " " + answer[answer.length-1];
    }
}