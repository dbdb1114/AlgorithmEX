import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a,b) -> {
            int res = a.charAt(n) - b.charAt(n);
            if (res == 0){
                return a.compareTo(b);
            }
            return res;
        });
        
        return strings;
    }
}

