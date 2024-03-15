import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        Set<String> ableWord = new HashSet<>();

        ableWord.add("aya");
        ableWord.add("ye");
        ableWord.add("woo");
        ableWord.add("ma");

        for (String word : babbling) {
            int st = 0;
            int len = 2;
            String prev = "";

            while (st < word.length()){
                String now = "";

                if(st + len <= word.length()
                    && ableWord.contains(word.substring(st, st + len))){
                    now = word.substring(st, st + len);
                    st = st + len;

                } else if (st + len + 1 <= word.length()
                        && ableWord.contains(word.substring(st, st + len + 1))){
                    now = word.substring(st, st + len + 1);
                    st = st + len + 1;
                } else {
                    break;
                }

                if(prev.equals(now)){
                    break;
                } else {
                    prev = now;
                }

                if(st == word.length()){
                    System.out.println(word);
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

}
