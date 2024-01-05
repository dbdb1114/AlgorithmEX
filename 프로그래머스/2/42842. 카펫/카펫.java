import java.util.ArrayList;


class Solution {
    public static ArrayList<int[]> findDivisor(int yellow) {
        ArrayList<int[]> res = new ArrayList<>();

        int width = yellow;

        while (width != 0){
            int height = yellow/width;
            boolean isDivide = yellow%width==0?true:false;

            if(width<height){
                break;
            }

            if(isDivide) {
                res.add(new int[] {width,height});
            }
            
            width--;
        }

        return res;
    }
public int[] solution(int brown, int yellow) {
           ArrayList<int[]> heightAndWidth = findDivisor(yellow);
        int[] answer = new int[2];

        for (int[] area: heightAndWidth) {

            int yellowWidth = area[0];
            int yellowHeight = area[1];
            int requiredBrown = yellowWidth*2 + yellowHeight*2 +4;

            if(requiredBrown == brown){
                answer[0] = yellowWidth + 2;
                answer[1] = yellowHeight + 2;
            }
        }

        return answer;
    }
}