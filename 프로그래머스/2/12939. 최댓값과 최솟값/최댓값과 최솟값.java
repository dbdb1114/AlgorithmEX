import java.util.Arrays;

class Solution {
    
    public static String solution(String s){
        String[] numbers = s.split(" ");

        int min = Integer.parseInt(numbers[0]);
        int max = Integer.parseInt(numbers[numbers.length-1]);

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            if(min > number) {
                min = number;
            } else if (max < number){
                max = number;
            }
        }

        return min + " " + max;
    }
}