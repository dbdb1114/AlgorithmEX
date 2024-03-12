import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s.chars().sorted().forEach(ch -> sb.append((char) ch));
        return sb.reverse().toString();
    }
}
