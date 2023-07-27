import java.util.HashMap;

class Solution {
     public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        /**
         요구사항 1. 가장 먼저 탈락하는 사람의 번호 ==>
         요구사항 2. 그 사람이 자신의 몇 번째 차례에서 탈락하는지 ==> words의 idx와 n으로 구할 수 있다.
         1. 맵을 쓴다면, key값으로, 단어가 들어간다.
         2. 해당 key를 넣을때 중복 되면 탈락 시킨다.
         3.
         */
        HashMap<String, Integer> dupleCheck = new HashMap<>();
        dupleCheck.put(words[0],1);
        for ( int i = 1; i < words.length; i++ ){

            String prevWord = words[i-1];
            String nowWord = words[i];

            if( dupleCheck.containsKey(words[i]) || prevWord.charAt(prevWord.length()-1) != nowWord.charAt(0)){
                
                /**
                 * 여기서 요구사항 구하면 된다.
                 * */
                if( i < n ){
                    answer[0] = i+1;
                    answer[1] = 1;
                } else {
                    answer[0] = i % n + 1; /** 그 사람의 번호 */
                    answer[1] = i / n == 0 ? i / n : i / n + 1;
                }
                break;
            } else {
                dupleCheck.put(words[i],i);
            }
        }

        System.out.println("Hello Java");

        return answer;
    }
}