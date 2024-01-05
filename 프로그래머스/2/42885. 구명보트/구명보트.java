import java.util.Arrays;

class Solution {
    public int solution(int[] peoples, int limit) {

        int boat = 0;
        int stPointer = 0;
        int edPointer = peoples.length-1;

        Arrays.sort(peoples);

        while(stPointer <= edPointer){
            int lighter = peoples[stPointer];
            int heavier = peoples[edPointer];

            if(lighter + heavier > limit){
                edPointer--;
                boat++;
            } else {
                edPointer--;
                stPointer++;
                boat++;
            }
        }

        return boat;

    }
}