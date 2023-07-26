class Solution {
public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];


        int number = (brown - 4)/2;

        for(int i = number - 1, j = 1 ; j <= i; i--, j++ ){
            if( i * j == yellow ){
                answer[0] = i+2;
                answer[1] = j+2;
                break;
            }
        }

        return answer;
    }
}