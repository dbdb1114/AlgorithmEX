import java.util.*;

public class Solution {
    public int solution(int n) {

        int distance = n;
        int usedEnergy = 0;

        while (distance != 0){
            if (distance % 2 == 0){
                distance = distance/2;
                continue;
            }
            if (distance % 2 == 1){
                usedEnergy++;
                distance--;
            }
        }

        return usedEnergy;
    }
}