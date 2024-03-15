/**

두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다)


X, Y의 짝꿍이 존재하지 않으면, 
짝꿍은 -1입니다. 
X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

X = 3403이고 Y = 13203이라면, 
X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 
3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 

X = 5525이고 Y = 1255이면 
X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 
2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다

결론
짝꿍은 같은 수이다. 

*/
import java.util.*;


class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        /**
         *  x와 y 둘 중 같은 문자를 골라서,
         *  해당 문자를 내림차순 정렬하면 된다.
         *
         *  X,Y 를 정렬
         *  같은 문자를 투 포인터를 써서 골라낸다음
         *  해당 문자를 다시 내림차순 정렬하면 됨.
         * */

        char[] xChars = X.toCharArray();
        char[] yChars = Y.toCharArray();

        Arrays.sort(xChars);
        Arrays.sort(yChars);

        int xId = xChars.length - 1;
        int yId = yChars.length - 1;

        
        while(xId >= 0 && yId >= 0){
            char x = xChars[xId];
            char y = yChars[yId];
            if(x == y){
                answer.append(xChars[xId]);
                xId--;
                yId--;
            } else if(x < y){
                yId--;
            } else {
                xId--;
            }
        }
        String reAnswer = answer.toString();
        long zeroCnt = reAnswer.chars().filter(x -> x == '0').count();

        if(reAnswer.length() < 1){
            reAnswer = "-1";
        } else if( reAnswer.length() == zeroCnt){
            reAnswer = "0";
        }

        return reAnswer;
    }
}